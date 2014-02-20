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


// Delete nodes from the tree
    public boolean delete(int value) {

        Node nodeToDelete = find(value);

        if (nodeToDelete != null) {
            if (nodeToDelete.getLeftChild() == null && nodeToDelete.getRightChild() == null) {
                // If leftchild and rightChild doesnot exsit in the tree
                delcase1(nodeToDelete);
            } else if (nodeToDelete.getLeftChild() != null) {
                // In case where leftChild should be Deleted
                delcase2(nodeToDelete);
            } else if (nodeToDelete.getRightChild() != null && nodeToDelete.getLeftChild() != null) {
                // In case where rightChild Should be Deleted 
                delcase3(nodeToDelete);
            } else if (nodeToDelete.getRightChild() != null) {
                delcase2(nodeToDelete);
            }
        }

        return false;
    }

    private void delcase1(Node nodeToDelete) {

        if (nodeToDelete.getParent().getLeftChild() == nodeToDelete) {
            //Deleting Left Child
            nodeToDelete.getParent().setLeftChild(null);

        } else if (nodeToDelete.getParent().getRightChild() == nodeToDelete) {
            //Deleting Right child
            nodeToDelete.getParent().setRightChild(null);

        }
    }
    
  
    private void delcase2(Node nodeToDelete) {

        if (nodeToDelete.getParent().getLeftChild() == nodeToDelete) {

            if (nodeToDelete.getLeftChild() != null) {

                nodeToDelete.getParent().setLeftChild(nodeToDelete.getLeftChild());

            } else if (nodeToDelete.getRightChild() != null) {
                nodeToDelete.getParent().setLeftChild(nodeToDelete.getRightChild());
            }
        } else if (nodeToDelete.getParent().getRightChild() == nodeToDelete) {

            if (nodeToDelete.getLeftChild() != null) {

                nodeToDelete.getParent().setRightChild(nodeToDelete.getLeftChild());

            } else if (nodeToDelete.getRightChild() != null) {
                nodeToDelete.getParent().setRightChild(nodeToDelete.getRightChild());
            }

        }
    }

    private void delcase3(Node nodeToDelete) {
        Node DelNode= new Node (a.getRightChild());
 /* Add the traversal code here and delete above node  */

        delcase2(DelNode);

        DelNode.setParent(nodeToDelete.getParent());
        DelNode.setLeftChild(nodeToDelete.getLeftChild());
        DelNode.setRightChild(nodeToDelete.getRightChild());

        if (nodeToDelete.getParent() == null) {
            root = DelNode;
        } else {
            if (nodeToDelete.getParent().getLeftChild() == nodeToDelete) {

                nodeToDelete.getParent().setLeftChild(DelNode);

            } else if (nodeToDelete.getParent().getRightChild() == nodeToDelete) {

                nodeToDelete.getParent().setRightChild(DelNode);
            }
        }
    }
}
