package dsa_trees;

public class BinaryTree {

    public Node root;
    public Node returnNode;

    // Tree constructor 
    public BinaryTree() {
        root = null;
    }

    // get root Node
    public Node getRoot() {
        return root;
    }

    // inserting a new node
    public void insert(int key) {

        Node newNode = new Node(key);

        if (root == null) {
            root = newNode;
        } else {

          /* add Traversal code here */

        }
    }

      // find a node in the tree
    public Node find(int value) {
        if (root != null) {
    // if the root is null there is no tree;
   //  if the root is not null, node will search recursivly 
            return findNode(root, new Node(value));
        }
        return null;
        
    }
    
     // find a node with a relevent key 
    private Node findNode(Node search, Node node) {

        if (search == null) {
            return null;
        }

        if (search.getKey() == node.getKey()) {
            return search;

        } else {
            returnNode = findNode(search.getLeftChild(), node);

            if (returnNode == null) {
                returnNode = findNode(search.getRightChild(), node);
            }
            return returnNode;
        }

    }
}