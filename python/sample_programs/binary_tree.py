# -*- coding: utf-8 -*-
"""Tree implementation in Python."""


class Node:
    """Node class."""

    def __init__(self, data):
        """Init method."""
        self.left = None
        self.right = None
        self.data = data

    def print_tree(self):
        """Method to print."""
        if self.left:
            self.left.print_tree()
        print(self.data, sep=' => ')
        if self.right:
            self.right.print_tree()

    def insert(self, data):
        """Method to insert."""
        if not self.data:
            self.data = data
        else:
            if data < self.data:
                if not self.left:
                    self.left = Node(data)
                else:
                    self.left.insert(data)
            else:
                if not self.right:
                    self.right = Node(data)
                else:
                    self.right.insert(data)

    def search(self, value):
        """Method to search."""
        if value == self.data:
            print('Found {val}!'.format(val=value))
        elif value < self.data:
            if not self.left:
                print('{val} - Not found'.format(val=value))
            else:
                self.left.search(value)
        else:
            if not self.right:
                print('{val} - Not found'.format(val=value))
            else:
                self.right.search(value)


if __name__ == '__main__':
    root = Node(12)
    root.insert(6)
    root.insert(15)
    root.insert(2)
    root.print_tree()
    root.search(22)
