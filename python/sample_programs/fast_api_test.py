# -*- coding: utf-8 -*-
"""Dummy API server using FastAPI."""

from fastapi import FastAPI

app = FastAPI()


@app.get('/')
async def get_index():
    """Index."""
    return {'message': 'OK'}
