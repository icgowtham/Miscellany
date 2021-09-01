# -*- coding: utf-8 -*-
"""Quick sort algorithm in Python."""


def quick_sort(arr):
    """
    Quick sort function.

    :param arr: list
        List of elements to be sorted.
    :return: None
    """
    if not arr:
        print('Empty array. Nothing to sort')
        return
    _quick_sort(arr, 0, len(arr) - 1)


def _quick_sort(arr, left, right):
    """
    Function to perform quick sort by recursion.

    :param arr: list
        List of elements to be sorted.
    :param left: int
        Left index.
    :param right: int
        Right index.
    :return: None
    """
    if left >= right:
        return
    pivot = arr[(left + right) // 2]
    index = _partition(arr, left, right, pivot)
    _quick_sort(arr, left, index - 1)
    _quick_sort(arr, index, right)


def _partition(arr, left, right, pivot):
    """
    Function to partition the array of elements.

    :param arr: list
        List of numbers.
    :param left: int
        Left index.
    :param right: int
        Right index.
    :param pivot: int
        Pivot element.
    :return: int
    """
    while left <= right:
        while arr[left] < pivot:
            left += 1
        while arr[right] > pivot:
            right -= 1
        if left <= right:
            arr[left], arr[right] = arr[right], arr[left]
            left += 1
            right -= 1
    return left


if __name__ == '__main__':
    arr_lst = [22, 45, 4, 0, 6, 3, 2, 44, 1]
    quick_sort(arr_lst)
    print(arr_lst)
