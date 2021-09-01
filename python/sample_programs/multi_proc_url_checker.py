# -*- coding: utf-8 -*-
"""Multiprocessing URL checker."""

import time
import requests
from multiprocessing import Pool
from multiprocessing import cpu_count

urls = []


def make_request(url):
    """
    Function to send the requests.

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
    Main driver function.

    :return:
    """
    with Pool(cpu_count()) as p:
        p.map(make_request, urls)


def main():
    """
    Entry-point.

    :return:
    """
    start = time.perf_counter()
    driver()
    end = time.perf_counter()
    print(f'Multiprocessing: {end - start:.2f}')


if __name__ == '__main__':
    main()
