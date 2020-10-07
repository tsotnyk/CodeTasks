package com.j2core.sts.leetcode.com.tmp.dataStructures.trees;

import java.util.Collection;

interface BinarySearchTreeSTS<K extends Comparable, V> {

        V getValue(K key);

        boolean updateValue(K key, V value);

        void addKey(K key, V value);

        void addKey(K... key);

        V removeKey(K key);

        K min();

        K max();

        K minX(int x);

        K maxX(int x);

        K floorKey(K key);

        K ceilKey(K key);

        Collection<K> getKeysAsc();

        Collection<K> getKeysDesc();

        Collection<K> getKeysBSF();

        Collection<K> getKeysDFSPreOrder();

        Collection<K> getKeysDFSInOrder();

        Collection<K> getKeysDFSInOrderReverse();

        Collection<K> getKeysDFSPostOrder();

        K searchValueBSF(V value);

        K searchValueDSFLeft(V value);

        K searchValueDSFRight(V value);

        int size();

        void printTree();

        void clear();
    }

