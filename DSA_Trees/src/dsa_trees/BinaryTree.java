package dsa_trees;

public class BinaryTree 
{
    //Declaring variables
    public Node root;
    public Node returnNode;

    // Tree constructor 
    public BinaryTree() 
    {
        root = null;
    }

    // get root Node
    public Node getRoot() 
    {
        return root;
    }

    // inserting a new node
    public void insert(int key) 
    {
        Node new_node = new Node(key);

        if (root == null) 
        {
            root = new_node;
        } 
        else 
        {
            //Traversal code,
         trvl_And_Add(root, new_node);
         
        }
    }

      // find a node in the tree
    public Node find(int value) 
    {
        if (root != null) 
        {
    // if the root is null there is no tree;
   //  if the root is not null, node will search recursivly 
            return findNode(root, new Node(value));
        }
        return null;
        
    }
    
     // find a node with a relevent key 
    private Node findNode(Node search, Node node) 
    {
        if (search == null) 
        {
            return null;
        }

        if (search.getKey() == node.getKey()) 
        {
            return search;
        }
        else 
        {
            returnNode = findNode(search.getLeftChild(), node);

            if (returnNode == null) 
            {
                returnNode = findNode(search.getRightChild(), node);
            }
            return returnNode;
        }

    }


// Delete nodes from the tree
    public boolean delete(int value) 
    {
        Node nodeToDelete = find(value);

        if (nodeToDelete != null) 
        {
            if (nodeToDelete.getLeftChild() == null && nodeToDelete.getRightChild() == null) 
            {
                // If leftchild and rightChild doesnot exsit in the tree
                delcase1(nodeToDelete);
            } 
            else if (nodeToDelete.getLeftChild() != null) 
            {
                // In case where leftChild should be Deleted
                delcase2(nodeToDelete);
            } 
            else if (nodeToDelete.getRightChild() != null && nodeToDelete.getLeftChild() != null) 
            {
                // In case where rightChild Should be Deleted 
                delcase3(nodeToDelete);
            } 
            else if (nodeToDelete.getRightChild() != null) 
            {
                delcase2(nodeToDelete);
            }
        }

        return false;
    }

    private void delcase1(Node nodeToDelete) 
    {

        if (nodeToDelete.getParent().getLeftChild() == nodeToDelete) 
        {
            //Deleting Left Child
            nodeToDelete.getParent().setLeftChild(null);

        } 
        else if (nodeToDelete.getParent().getRightChild() == nodeToDelete) 
        {
            //Deleting Right child
            nodeToDelete.getParent().setRightChild(null);

        }
    }
    
  
    private void delcase2(Node nodeToDelete) 
    {

        if (nodeToDelete.getParent().getLeftChild() == nodeToDelete) 
        {

            if (nodeToDelete.getLeftChild() != null) 
            {

                nodeToDelete.getParent().setLeftChild(nodeToDelete.getLeftChild());

            } 
            else if (nodeToDelete.getRightChild() != null) 
            {
                nodeToDelete.getParent().setLeftChild(nodeToDelete.getRightChild());
            }
        } 
        else if (nodeToDelete.getParent().getRightChild() == nodeToDelete) 
        {

            if (nodeToDelete.getLeftChild() != null) 
            {
                nodeToDelete.getParent().setRightChild(nodeToDelete.getLeftChild());

            } 
            else if (nodeToDelete.getRightChild() != null) 
            {
                nodeToDelete.getParent().setRightChild(nodeToDelete.getRightChild());
            }

        }
    }

    private void delcase3(Node nodeToDelete) 
    {
        //traversal code,
        Node DelNode = min_LeftTraversal(nodeToDelete.getRightChild());

        delcase2(DelNode);

        DelNode.setParent(nodeToDelete.getParent());
        DelNode.setLeftChild(nodeToDelete.getLeftChild());
        DelNode.setRightChild(nodeToDelete.getRightChild());

        if (nodeToDelete.getParent() == null) 
        {
            root = DelNode;
        } 
        else 
        {
            if (nodeToDelete.getParent().getLeftChild() == nodeToDelete) 
            {

                nodeToDelete.getParent().setLeftChild(DelNode);

            } 
            else if (nodeToDelete.getParent().getRightChild() == nodeToDelete) 
            {

                nodeToDelete.getParent().setRightChild(DelNode);
            }
        }
    }
    
    // travel the tree for delete the node
    private Node min_LeftTraversal(Node node) 
    {
        if (node.getLeftChild() == null) 
        {
            return node;
        }
        return min_LeftTraversal(node.getLeftChild());
    }

    // find the place before adding the node
    private void trvl_And_Add(Node node, Node new_node) 
    {
        if (new_node.getKey() < node.getKey()) 
        {
            if (node.getLeftChild() == null) 
            {
                new_node.setParent(node);
                node.setLeftChild(new_node);
                
            } 
            else 
            {
                trvl_And_Add(node.getLeftChild(), new_node);
            }

        } 
        else if (new_node.getKey() > node.getKey()) 
        {
            if (node.getRightChild() == null) 
            {
                new_node.setParent(node);
                node.setRightChild(new_node);
            } 
            else 
            {
                trvl_And_Add(node.getRightChild(), new_node);
            }
        }
    }

    // taverse the tree through the nodes
    public void traverse() 
    {
        if (root != null) 
        {
                // if the root is empty there is no tree to be traverse , so the task is end 
            // if the root isn't an empty one
            Node nodetraverse = root;
            if (nodetraverse.getLeftChild() == null && nodetraverse.getRightChild() == null) 
            {
                System.out.println(nodetraverse.getKey());
            } 
            else 
            {
                if (nodetraverse.getLeftChild() != null) 
                {
                    // if the left child of the node is null recursive call for the method Inordertraverse
                    Inordertraverse(nodetraverse.getLeftChild());
                }
                if (nodetraverse.getRightChild() != null) 
                {
                    // if the right child of the node null recursive call for the method Inordertraverse
                    Inordertraverse(nodetraverse.getRightChild());
                }
            }
        }
    }

    // transversal through the nodes and print the nodes
    private void Inordertraverse(Node node) 
    {
        if (node.getLeftChild() != null) 
        {
            Inordertraverse(node.getLeftChild());
        }
        System.out.println(node.getKey());

        if (node.getRightChild() != null) 
        {
            Inordertraverse(node.getRightChild());
        }
    }

}//close tag *Tag Matching ;)

