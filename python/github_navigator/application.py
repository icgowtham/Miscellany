"""Sample Flask based application for search GitHub repositories."""

from flask import Flask, request, render_template, flash
from wtforms import Form, TextField, validators
import json
import datetime
import requests
from repoze.lru import CacheMaker

__author__ = "Ishwarachandra Gowtham"
__version__ = "1.0"
__email__ = "ic.gowtham@gmail.com"


# Create a Flask application with templates folder same
# as the application folder.
app = Flask(__name__, template_folder='.')
app.config.from_object(__name__)
app.config['SECRET_KEY'] = '0g1o2w3t4h5a6m'
# Cache for holding the HTTP response.
cache_maker = CacheMaker()


class AppForm(Form):
    """The input form."""
    search_term = TextField('Enter the Search Term:', validators=[validators.required()])


@app.route('/', methods=['GET', 'POST'])
def main():
    """Route for the index."""
    form = AppForm(request.form)
    # 1. Make a 'GET' request with the 'search_term'.
    if request.method == 'GET':
        search_term = request.args.get('search_term', '')
        if search_term:
            repos = get_repositories(search_term=search_term)
            if repos:
                return render_template('/template.html',
                                       search_term=search_term,
                                       repos=repos)
            else:
                flash('No data found.')
    return render_template('/index.html', form=form)


@cache_maker.expiring_lrucache(maxsize=300, timeout=30)
def get_repositories(search_term):
    """
    Method to fetch the repository information based on the search term.

    :param search_term: str
        The search term
    :return: list of dict
        List of dictionaries with the search results.
    """
    token = 'aefd99372fa761b20de8de3d2e694759c716fee5'
    headers = {'Authorization': 'token {tkn}'.format(tkn=token)}
    # 2. Fetch the first page of results.
    url = 'https://api.github.com/search/repositories?q={st}&page=1'.format(
        st=search_term)
    try:
        response = requests.get(url=url, headers=headers)
        response.raise_for_status()
        if response.status_code == requests.codes.ok:
            repos_data = response.json()['items']
            # 3. Sort the results the 'created_at' by descending order.
            sorted_repos_data = sorted(repos_data,
                                       key=lambda item: item['created_at'],
                                       reverse=True)
            # 4. Get the information about the latest 5 repositories.
            sorted_repos_data = sorted_repos_data[0:5]
            for repo in sorted_repos_data:
                # Remove the '{\sha}' part from the commit url.
                commits_url = repo['commits_url'].split('{')[0]
                # I could not find a way to avoid this second request.
                # There seem to be no other way to get the commits information.
                commits_response = requests.get(url=commits_url,
                                                headers=headers)
                commits_response.raise_for_status()
                if commits_response.status_code == requests.codes.ok:
                    commits_data = commits_response.json()[0]
                    repo['sha'] = commits_data['sha']
                    repo['commit_message'] = commits_data['commit']['message']
                    repo['commit_author'] = commits_data['commit']['author']['name']
            return json.loads(json.dumps(sorted_repos_data, default=datetime_json_handler))
    except requests.exceptions.RequestException as e:
        print(str(e))
        raise


def datetime_json_handler(obj):
    """
    Custom handler for serializing datetime objects.

    The datetime objects throw a 'not JSON serializable exception'.
    This is a custom handler for datetime objects.
    :param obj: Object to check
    :return: String
    """
    if isinstance(obj, datetime.datetime):
        return obj.__str__()


def clear_cache():
    """Method for clearing the cache."""
    if cache_maker:
        cache_maker.clear()


if __name__ == "__main__":
    """Start the application by exposing the host machine IP."""
    app.run(host='0.0.0.0', debug=True)
