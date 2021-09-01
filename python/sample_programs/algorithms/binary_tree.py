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
        print(self.data, end=' => ')
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

    def get_height(self, root_node):
        """Method to get the height of the tree."""
        if root_node is None:
            return 0
        else:
            return max(self.get_height(root_node.left), self.get_height(root_node.right)) + 1

    def check_height(self, root_node):
        """Method to check the height."""
        if not root_node:
            return 0

        left_height = self.check_height(root_node.left)
        if left_height == -1:
            return -1

        right_height = self.check_height(root_node.right)
        if right_height == -1:
            return -1

        height_diff = left_height - right_height
        if abs(height_diff) > 1:
            return -1
        else:
            return max(left_height, right_height) + 1

    def is_balanced(self, root_node):
        """Check if tree is balanced."""
        if self.check_height(root_node) == -1:
            return False
        return True


if __name__ == '__main__':
    root = Node(12)
    root.insert(6)
    root.insert(15)
    root.insert(2)
    root.insert(22)
    root.print_tree()
    # root.search(22)
    print('Depth: ' + str(root.get_height(root)))
    print(root.is_balanced(root))
