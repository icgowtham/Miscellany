"""Tree implementation."""


class Node(object):
    """Node class."""

    def __init__(self, data=None):
        """Init method."""
        self.left = None
        self.right = None
        self.data = data

    # for setting left node
    def set_left(self, node):
        """Set left node."""
        self.left = node

    # for setting right node
    def set_right(self, node):
        """Set right node."""
        self.right = node

    # for getting the left node
    def get_left(self):
        """Get left node."""
        return self.left

    # for getting right node
    def get_right(self):
        """Get right node."""
        return self.right

    # for setting data of a node
    def set_data(self, data):
        """Set data."""
        self.data = data

    # for getting data of a node
    def get_data(self):
        """Get data."""
        return self.data


# Left -> Root -> Right: ./\.
def in_order(node):
    """In-order traversal (Left->Root->Right)."""
    if node:
        in_order(node.get_left())
        print(node.get_data(), end=' ')
        in_order(node.get_right())
    return


# Root -> Left ->Right: \._.
def pre_order(node):
    """Pre-order traversal (Root->Left->Right)."""
    if node:
        print(node.get_data(), end=' ')
        pre_order(node.get_left())
        pre_order(node.get_right())
    return


# Left -> Right -> Root: ._.\
def post_order(node):
    """Post-order traversal (Left->Right->Root)."""
    if node:
        post_order(node.get_left())
        post_order(node.get_right())
        print(node.get_data(), end=' ')
    return


if __name__ == '__main__':
    root = Node(1)
    root.set_left(Node(2))
    root.set_right(Node(3))
    root.left.set_left(Node(4))

    print('In-order  Traversal:')
    in_order(root)
    print('\nPre-order Traversal:')
    pre_order(root)
    print('\nPost-order Traversal:')
    post_order(root)

    # OUTPUT:
    # Inorder  Traversal:
    # 4 2 1 3
    # Preorder Traversal:
    # 1 2 4 3
    # Postorder Traversal:
    # 4 2 3 1
