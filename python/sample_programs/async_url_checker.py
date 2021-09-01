# -*- coding: utf-8 -*-
"""Async IO URL checker."""
import time
import httpx
import asyncio

urls = []
async_client = httpx.AsyncClient()


async def make_request(url):
    """

    :param url:
    :return:
    """
    try:
        res = await async_client.head(url, timeout=3)
        print(res.status_code)
    except Exception as e:
        print(e.__class__.__name__)


async def driver():
    """

    :return:
    """
    await asyncio.gather(*[make_request(url) for url in urls])


def main():
    """

    :return:
    """
    start = time.perf_counter()
    asyncio.run(driver())
    end = time.perf_counter()
    print(f'Async IO: {end - start:.2f}')


if __name__ == '__main__':
    main()
