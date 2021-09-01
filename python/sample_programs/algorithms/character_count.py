# -*- coding: utf-8 -*-
"""Python program to count consecutive characters in a string."""


def count_chars(string):
    """Count consecutive characters."""
    current = [string[0], 1]
    output = [current]
    for ch in string[1:]:
        if ch == current[0]:
            current[1] += 1
        else:
            current = [ch, 1]
            output.append(current)
    output = ''.join([str(ch) for item in output for ch in item])
    return output


if __name__ == '__main__':
    inp = 'aaabbbccddfggghaab'
    """
    from itertools import groupby
    out = ''.join([k + str(len(list(g))) for k, g in groupby(inp)])
    print(out)
    """
    print(count_chars(inp))
