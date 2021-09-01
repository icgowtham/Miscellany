# -*- coding: utf-8 -*-
"""Very basic hash table implementation."""


class HashTable:
    """Class for the hashtable."""

    __slots__ = ('_hash_table', '_index', '_size')

    def __init__(self, size=50, kv_pair=None):
        """
        Initialization method.

        :param size: int
            Size of the hash bucket.
        """
        self._index = 0
        self._size = size
        if kv_pair and isinstance(kv_pair, dict):
            self._hash_table = self._create_buckets()
            for key in kv_pair:
                self.put(key, kv_pair[key])
        else:
            self._hash_table = self._create_buckets()

    def __getitem__(self, key):
        """
        Use subscript notation to get the item.

        :param key: object
            Key can be int, str or any object.
        :return:
        """
        return self.get(key)

    def __setitem__(self, key, value):
        """
        Use subscript notation to add/update a key.

        :param key: object
            Key can be int, str or any object.
        :param value: object
            Value can be int, str or any object.
        :return: None
        """
        self.put(key, value)

    def __iter__(self):
        """
        Iterator.

        :return: object
        """
        return self

    def __next__(self):
        """
        Next method.

        :return: object
        """
        key = None
        try:
            while 1:
                item = self._hash_table[self._index]
                self._index += 1
                if item and isinstance(item[0], tuple):
                    key = item[0][0]
                    break
        except IndexError:
            raise StopIteration()
        # self._index += 1
        return key

    def __len__(self):
        """Method for len."""
        count = 0
        for item in self._hash_table:
            if item and isinstance(item[0], tuple):
                count += 1
        return count

    def _create_buckets(self):
        """
        Initialize the hash buckets.

        :return: list
        """
        return [[] for _ in range(self._size)]

    def search(self, key):
        """
        Method to check whether key exists in the map.

        :param key: object
            Key can be int, str or any object.
        :return: boolean
        """
        bucket = self.get_bucket(key)
        is_key_found = False
        for index, record in enumerate(bucket):
            record_key, record_val = record
            if record_key == key:
                is_key_found = True
                break
        return is_key_found

    def get_bucket(self, key):
        """
        Method to get the hashed index.

        :param key: object
            Key can be int, str or any object.
        :return: object
            Bucket corresponding to the index.
        """
        hashed_key = hash(key) % self._size
        # Get the bucket corresponding to index
        bucket = self._hash_table[hashed_key]
        return bucket

    def get(self, key):
        """
        Method to retrieve an entry based on key.

        :param key: object
            Key can be int, str or any object.
        :return: object
            Value can be int, str or any object.
        """
        bucket = self.get_bucket(key)
        for index, record in enumerate(bucket):
            record_key, record_val = record
            if record_key == key:
                return record_val
        return None

    def put(self, key, value):
        """
        Method to add or update entries based on a key.

        :param key: object
            Key can be int, str or any object.
        :param value: object
            Value can be int, str or any object.
        :return: None
        """
        bucket = self.get_bucket(key)
        is_key_found = False
        index = 0
        for idx, record in enumerate(bucket):
            record_key, record_val = record
            if record_key == key:
                is_key_found = True
                index = idx
                break
        if is_key_found:
            bucket[index] = (key, value)
        else:
            bucket.append((key, value))

    def __str__(self):
        """String representation."""
        values = []
        for item in self._hash_table:
            for key, val in item:
                values.append(str(key) + ' --> ' + str(val))
        return '\n'.join(values)

    def __repr__(self):
        """Repr for the class."""
        return ''.join([self.__class__.__name__, '(', str(self._size), ')'])


if __name__ == '__main__':
    """
    kv = {1: 'a', 2: 'b', 3: 'c'}
    ht = HashTable(kv_pair=kv)
    """
    ht = HashTable()
    ht.put('a', 1)
    ht.put('b', 2)
    ht['c'] = 3
    ht['z'] = 26
    for k in ht:
        print(k, ' <==> ', ht[k])
    print(len(ht))
    ht['c'] = 99
    ht['z'] = '260'
    for k in ['c', 'z']:
        print(k, ' <@@> ', ht[k])
