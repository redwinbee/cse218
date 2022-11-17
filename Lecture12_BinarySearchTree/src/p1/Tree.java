package p1;

public class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1 -> {
                System.out.print("preorder traversal: ");
                preOrder(root);
            }
            case 2 -> {
                System.out.print("inorder traversal: ");
                inOrder(root);
            }
            case 3 -> {
                System.out.print("postorder traversal: ");
                postOrder(root);
            }
        }

        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    public boolean remove(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.iData != key) {
            parent = current;
            if (key < current.iData) { // go left
                isLeftChild = true;
                current = current.leftChild;
            } else { // go right
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null) {
                return false; // nothing to delete
            }
        }

        // found the key -- test the 3 possibilities of the state of this parent's children
        // case 1: the current node has no children
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null; // the tree only had 1 node -- it is now empty
            } else if (isLeftChild) {
                parent.leftChild = null; // tell the parent its left child is gone
            } else {
                parent.rightChild = null; // tell the parent its right child is gone
            }
        }

        // case 2a: the current doesn't have a right child, replace with left subtree
        else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
            // case 2b: the current doesn't have a left child, replace with right subtree
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        }

        // case 3: the current has two children
        else {
            // we need the successor
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }

            successor.leftChild = current.leftChild; // adopt the currents left child
        }

        return true;
    }

    private Node getSuccessor(Node delNode) { // find the successor of the node we want to delete
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; // go to right child
        while (current != null) { // keep going left until no more left child
            successorParent = successor;
            successor = current;
            current = current.leftChild; // go to left child
        }

        if (successor != delNode.rightChild) { // if the successor is not a right child then make the connections
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }

    public Node find(int key) {
        Node current = root;
        while (current.iData != key) {
            current = (key < current.iData) ? current.leftChild : current.rightChild;
            if (current == null) {
                return null; // key doesn't exist in the tree
            }
        }

        return current; // found the key, return the current Node
    }

    public Node minimum() {
        Node current = root;
        Node last = null; // last left node
        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last; // escaped while-loop so this is the last left node
    }

    public Node maximum() {
        Node current = root;
        Node last = null; // last right node
        while (current != null) {
            last = current;
            current = current.rightChild;
        }

        return last; // escaped while-loop so this is the last right node
    }

    public void insert(int iData, double dData) {
        Node node = new Node();
        node.iData = iData;
        node.dData = dData;

        if (root == null) {
            root = node;
        } else { // tree isn't empty
            Node current = root;
            Node parent;
            while (true) { // find an empty spot in the tree
                parent = current;
                if (iData < current.iData) { // go left
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else { // go right
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }
}
