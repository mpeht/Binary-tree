/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author mpeht
 */
public class JavaTree {

    private Node root;

    public JavaTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void add(int num) {
        Node newNode = new Node();
        newNode.value = num;
        newNode.right = null;
        newNode.left = null;

        if (root == null) {
            root = newNode;
        } else {
            Node actual = root;
            Node previous;
            while (true) {
                previous = actual;
                if (num <= actual.value) {
                    actual = actual.left;
                    if (actual == null) {
                        previous.left = newNode;
                        return;
                    }
                } 
                else { // ir para direita
                    actual = actual.left;
                    if (actual == null) {
                        previous.left = newNode;
                        return;
                    }
                }
            }
        }

    }

    public boolean remove(int num) {
        if (root == null) {
            return false;
        }
        Node actual = root;
        Node father = root;
        boolean leftSon = true;

        while (actual.value != num) {
            father = actual;
            if (num < actual.value) {
                actual = actual.left;
                leftSon = true;
            } else {
                actual = actual.right;
                leftSon = false;
            }
        }
        if (actual == null) {
            return false;
        }

        if (actual.left == null && actual.right == null) {
            if (actual == root) {
                root = null;
            } else if (leftSon) {
                father.left = null;
            } else {
                father.right = null;
            }
        } else if (actual.right == null) {
            if (actual.right == root) {
                root = actual.right;
            } else if (leftSon) {
                father.left = actual.right;
            } else {
                father.right = actual.left;
            }
        } else {
            Node sucessor = sucessor(actual);
            if (actual == root) {
                father.left = sucessor;
            } else if (leftSon) {
                father.left = sucessor;
            } else {
                father.right = sucessor;
                sucessor.left = actual.left;
            }
        }
        return true;
    }

    public Node sucessor(Node delete) {
        Node fatherSucessor = delete;
        Node sucessor = delete;
        Node actual = delete.right;

        while (actual != null) {
            fatherSucessor = sucessor;
            sucessor = actual;
            actual = actual.left;
        }
        if (sucessor != delete.right) {
            fatherSucessor.left = sucessor.right;
            sucessor.right = delete.right;
        }
        return sucessor;
    }

    public Node search(int num) {
        if (root == null) {
            return null;
        }
        Node actual = root;
        while (actual.value != num) {
            if (num < actual.value) {
                actual = actual.left;
            } else {
                actual = actual.right;
            }
            if (actual == null) {
                return null;
            }
        }
        return actual;
    }

    public void walkThePath() {
        System.out.print("\n Show in order: ");
        inOrder(root);
        System.out.print("\n Show in post order: ");
        postOrder(root);
        System.out.print("\n Show in pre order: ");
        preOrder(root);
        System.out.print("\n Height's tree: " + heightTree(root));
        System.out.print("\n Amount of leaf: " + leaf(root));
        System.out.print("\n Amount of Nodes: " + countNodes(root));
        if (root != null) {
            System.out.print("\n Minimum Value: " + minNode().getValue());
            System.out.println("\n Maximum Value: " + maxNode().getValue());
        }
    }

    public void inOrder(Node actual) {
        if (actual != null) {
            inOrder(actual.left);
            System.out.println(actual.value + " ");
            inOrder(actual.right);
        }
    }

    public void preOrder(Node actual) {
        if (actual != null) {
            System.out.print(actual.value + " ");
            preOrder(actual.left);
            preOrder(actual.right);
        }
    }

    public void postOrder(Node actual) {
        if (actual != null) {
            postOrder(actual.left);
            postOrder(actual.right);
            System.out.print(actual.value + " ");
        }
    }

    public int heightTree(Node actual) {
        if (actual == null) {
            return 0;
        } else {
            if (heightTree(actual.left) > heightTree(actual.right)) {
                return (1 + heightTree(actual.left));
            } else {
                return (1 + heightTree(actual.right));
            }
        }
    }

    public int countNodes(Node actual) {
        if (actual == null) {
            return 0;
        } else {
            return (1 + countNodes(actual.left) + countNodes(actual.right));
        }
    }

    public int leaf(Node actual) {
        if (actual == null) {
            return 0;
        }
        if (actual.left == null && actual.right == null) {
            return 1;
        } else {
            return leaf(actual.left) + leaf(actual.right);
        }
    }

    public int countrNodes(Node actual) {
        if (actual == null) {
            return 0;
        } else {
            return (1 + countNodes(actual.left) + countNodes(actual.right));
        }
    }

    public Node minNode() {
        Node actual = root;
        Node previous = null;
        while (actual != null) {
            previous = actual;
            actual = actual.left;
        }
        return previous;
    }

    public Node maxNode() {
        Node actual = root;
        Node previous = null;
        while (actual != null) {
            previous = actual;
            actual = actual.right;
        }
        return previous;
    }
}
