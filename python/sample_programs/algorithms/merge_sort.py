# -*- coding: utf-8 -*-
"""Merge sort algorithm in Python."""
import copy


def merge_sort(arr):
    if not arr:
        print('Empty array, nothing to sort.')
        return
    temp_arr = []
    _merge_sort(arr, temp_arr, 0, len(arr) - 1)


def _merge_sort(arr, temp_arr, left_start, right_end):
    if left_start >= right_end:
        return
    middle = (left_start + right_end) // 2
    _merge_sort(arr, temp_arr, left_start, middle)
    _merge_sort(arr, temp_arr, middle + 1, right_end)
    _merge(arr, temp_arr, left_start, right_end)


def _merge(arr, temp_arr, left_start, right_end):
    left_end = (right_end + left_start) // 2
    right_start = left_end + 1
    size = right_end - left_start + 1

    left = left_start
    right = right_start
    index = left_start

    while left <= left_end and right <= right_end:
        print(left)
        print(arr[right])
        if arr[left] <= arr[right]:
            temp_arr.insert(index, arr[left])
            left += 1
        else:
            temp_arr.insert(index, arr[right])
            right += 1
        index += 1
    dummy = arr[:]
    arr[0:left] = [copy.deepcopy(item) for item in temp_arr[index:(left_end - left + 1)]]
    arr[0:right] = [copy.deepcopy(item) for item in temp_arr[index:(right_end - right + 1)]]
    temp_arr[0:left_start] = [copy.deepcopy(item) for item in arr[left_start:size]]
    print(temp_arr)


if __name__ == '__main__':
    lst = [22, 45, 4, 0, 6, 3, 2, 44, 1]
    merge_sort(lst)
