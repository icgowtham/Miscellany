"""Binary Search Tree."""
from random import randint


class Node:
    """Node class."""

    def __init__(self, value):
        """Init method."""
        self.value = value
        self.left = None
        self.right = None

    def __repr__(self):
        """Repr method."""
        return str(self.value)


class BST:
    """BST class."""

    def __init__(self):
        """Init method."""
        self.root = None

    def __repr__(self):
        """Repr method."""
        self.sorted = []
        self.get_inorder(self.root)
        return str(self.sorted)

    def get_inorder(self, node):
        """In-order traversal (Left->Root->Right)."""
        if node:
            self.get_inorder(node.left)
            self.sorted.append(str(node.value))
            self.get_inorder(node.right)

    def add(self, value):
        """Add method."""
        if not self.root:
            self.root = Node(value)
        else:
            self._add(self.root, value)

    def _add(self, node, value):
        """Helper method."""
        if value <= node.value:
            if node.left:
                self._add(node.left, value)
            else:
                node.left = Node(value)
        else:
            if node.right:
                self._add(node.right, value)
            else:
                node.right = Node(value)


if __name__ == '__main__':
    bst = BST()

    for i in range(10):
        bst.add(randint(1, 1000))
    print(bst)
