# -*- coding: utf-8 -*-
"""Quick sort implementation in Python."""


def partition(array, begin, end):
    """Partition function."""
    pivot_idx = begin
    """
    arr = [9, 3, 4, 8, 1]
    pivot = 0
    i = 1, begin = 0
    3 <= 9 -> swap -> [3, 9, 4, 8, 1]
    pivot = 1
    i = 2, pivot = 1
    4 <= 9 -> swap -> [3, 4, 9, 8, 1]
    pivot = 2
    i = 3, pivot = 2
    8 <= 9 -> swap -> [3, 4, 8, 9, 1]
    pivot = 3
    i = 4, pivot = 3
    1 <= 9 -> swap -> [3, 4, 8, 1, 9]
    pivot = 4
    i = 5, pivot = 4
    """
    for i in range(begin + 1, end + 1):
        if array[i] <= array[begin]:
            pivot_idx += 1
            array[i], array[pivot_idx] = array[pivot_idx], array[i]
    array[pivot_idx], array[begin] = array[begin], array[pivot_idx]
    print(array)
    return pivot_idx


def quick_sort_recursion(array, begin, end):
    """Recursive function."""
    if begin >= end:
        return
    pivot_idx = partition(array, begin, end)
    print(pivot_idx)
    quick_sort_recursion(array, begin, pivot_idx - 1)
    quick_sort_recursion(array, pivot_idx + 1, end)


def quick_sort(array, begin=0, end=None):
    """Quick sort function."""
    if end is None:
        end = len(array) - 1
    return quick_sort_recursion(array, begin, end)


if __name__ == '__main__':
    arr = [9, 3, 4, 8, 1]
    quick_sort(arr)
    print(arr)
