"""Linked list implementation."""


class Node:
    """Node class."""

    def __init__(self, value=None, next=None):
        """Init method."""
        self.value = value
        self.next = next

    def get_value(self):
        """Get value."""
        return self.value

    def __str__(self):
        """Str."""
        return str(self.value)


def print_list(node):
    """Print the list contents."""
    while node:
        print(node.get_value(), end=" -> ")
        node = node.next
    print('None')


if __name__ == '__main__':
    node1 = Node("car")
    node2 = Node("bus")
    node3 = Node("lorry")
    node1.next = node2
    node2.next = node3
    print_list(node1)
