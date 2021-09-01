# -*- coding: utf-8 -*-
"""Mutli-threaded URL checker."""

import time
import requests
import threading

urls = []


def make_request(url):
    """

    :param url:
    :return:
    """
    try:
        res = requests.head(url, timeout=3)
        print(res.status_code)
    except Exception as e:
        print(e.__class__.__name__)


def driver():
    """

    :return:
    """
    threads = []
    for url in urls:
        t = threading.Thread(target=make_request, args=(url,))
        threads.append(t)

    for t in threads:
        t.start()

    for t in threads:
        t.join()


def main():
    """

    :return:
    """
    start = time.perf_counter()
    driver()
    end = time.perf_counter()
    print(f'Threading: {end - start:.2f}')


if __name__ == '__main__':
    main()
