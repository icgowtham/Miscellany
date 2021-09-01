# -*- coding: utf-8 -*-
"""Binary search implementation in Python."""
from collections.abc import Iterable


class BinarySearch:
    """Binary search class."""

    def __init__(self, elements):
        """Initialization method."""
        if not isinstance(elements, Iterable):
            raise Exception('Not supported')
        print(elements)
        self.elements = elements
        self.elements.sort()
        print(self.elements)

    def sort(self):
        """Sort elements."""
        self.elements = sorted(self.elements)

    def search(self, key):
        """Search method."""
        return self._search(self.elements, key)

    def _search(self, elements, key):
        """Private method."""
        if not elements:
            print('Key {k} not found.'.format(k=key))
            return
        low, high = 0, (len(elements) - 1)
        mid = (low + high) // 2
        if key == elements[mid]:
            print('Found {ele}.'.format(ele=key))
            return self.elements.index(key)
        elif key < elements[mid]:
            return self._search(elements[:mid], key)
        elif key > elements[mid]:
            return self._search(elements[mid + 1:], key)


if __name__ == '__main__':
    data = [9, 1, 2, 8, 6, 5]
    bs = BinarySearch(data)
    k = bs.search(5)
    print(k)
