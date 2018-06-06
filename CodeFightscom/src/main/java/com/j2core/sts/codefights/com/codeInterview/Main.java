package com.j2core.sts.codefights.com.codeInterview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


    /**
     * The idea is that insert flow will match traverse flow, so we can fill the data, traverse and compare.
     *
     */
    public class Main {

        class Node {
            int value;
            Node left;
            Node right;

            public Node(int value) {
                this.value = value;
                left = null;
                right = null;
            }
        }

        class BST {
            Node root = null;

            public void insertAll(int[] values) {
                for (int value : values) {
                    insert(value);
                }
            }

            public void insert(int value) {
                if (root == null) {
                    root = new Node(value);
                } else {

                    Node current = root;

                    while (true) {
                        if (value == current.value) {
                            break;
                        } else if (value < current.value) {
                            if (current.left == null) {
                                current.left = new Node(value);
                                break;
                            } else {
                                current = current.left;
                                continue;
                            }
                        } else if (value > current.value) {
                            if (current.right == null) {
                                current.right = new Node(value);
                                break;
                            } else {
                                current = current.right;
                                continue;
                            }
                        }
                    }

                }



                // TODO: IMPLEMENT
            }

            public int[] traverse() {
                // TODO: IMPLEMENT

                // We are going to traverse, let it be my stack
                List<Node> unprocessedNodes = new LinkedList<Node>();

                List<Integer> values = new LinkedList<>();

                unprocessedNodes.add(root);

                while (!unprocessedNodes.isEmpty()) {
                    // Okay, we've got the node
                    Node current = unprocessedNodes.remove(0);
                    // save value
                    values.add(current.value);
                    // we have to traverse left, then right, right? ;)
                    if (current.right != null) {
                        unprocessedNodes.add(0,current.right);
                    }
                    if (current.left != null) {
                        unprocessedNodes.add(0,current.left);
                    }

                }


                return toIntArray(values);
            }


        }

        // meh.... no time, will fix later this mess
        private int[] toIntArray(List<Integer> list){
            int[] ret = new int[list.size()];
            for(int i = 0;i < ret.length;i++)
                ret[i] = list.get(i);
            return ret;
        }


        public static void main(String[] args) {

            String[] userInput = getUserInput();
            List<int[]> traverseRecords = parseUserInput(userInput);

            for (int[] traverseRecord : traverseRecords) {
                System.out.println(isTreeCorrect(traverseRecord) ? "YES" : "NO");
            }

        }

        private static boolean isTreeCorrect(int[] traverseRecord) {
            // boom and zoom
            BST bst = new Main().new BST();
            bst.insertAll(traverseRecord);

            return Arrays.equals(traverseRecord, bst.traverse());
        }

        private static List<int[]> parseUserInput(String[] userInput) {
            // TODO: IMPLEMENT LATE, AFTER LOGIC IMPLEMENTED
            return null;
        }

        private static String[] getUserInput() {
            // TODO: IMPLEMENT LATE, AFTER LOGIC IMPLEMENTED
            return null;
        }

        @Test
        public void happyPathTest() {
            assertTrue(isTreeCorrect(new int[]{1}));
            assertTrue(isTreeCorrect(new int[]{1,3,4}));
            assertTrue(isTreeCorrect(new int[]{1,3,2}));
            assertTrue(isTreeCorrect(new int[]{6,5,4,7}));
        }
        @Test
        public void negativeTest() {
            assertFalse(isTreeCorrect(new int[]{1,3,4,2}));
            assertFalse(isTreeCorrect(new int[]{3,4,5,1}));

        }

    }
