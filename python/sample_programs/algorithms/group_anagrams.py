# -*- coding: utf-8 -*-
"""Python program to group anagrams from a list of strings."""


def group_anagrams(input_data):
    """Group anagrams using a common key."""
    groups = {}
    for item in input_data:
        key = ''.join(sorted(item))
        if groups.get(key) is None:
            groups[key] = [item]
        else:
            groups[key].append(item)
    return groups


if __name__ == '__main__':
    data = ['eat', 'ate', 'tea', 'ant', 'tan',
            'bat', 'adobe', 'abode', 'listen', 'silent',
            'tab', 'xyz']
    ana_map = group_anagrams(data)
    grouped_list = [ana_map[k] for k in ana_map]
    print(grouped_list)
