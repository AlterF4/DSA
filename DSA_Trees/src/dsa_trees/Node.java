package dsa_trees;


public class Node 
{
    
    // Private data items
    private Node left;
    private Node right;
    private Node parent;   // keep a refrence 
    private int key; //ISBN
    private String name; //Book name
    private String fst_name; //author's first name
    private String sur_name; //author's sur name

    public Node(int key,String name,String fst_name,String sur_name) 
    {
        this.key = key;
        this.name = name;
        this.fst_name = fst_name;
        this.sur_name = sur_name;
        left = null;
        right = null;
    }

    public void setLeftChild(Node left) 
    {
        this.left = left;
    }

    public void setRightChild(Node right) 
    {
        this.right = right;
    }

    public void setKey(int key) 
    {
        this.key = key;
    }

    public void setParent(Node parent) 
    {
        this.parent = parent;
    }

    public Node getLeftChild() 
    {
        return left;
    }

    public Node getRightChild() 
    {
        return right;
    }

    public int getKey() 
    {
        return key;
    }

    public String getName()
    {
        return name;
    }
    
    public String getf_name()
    {
        return fst_name;
    }
    
    public String gets_name()
    {
        return sur_name;
    }
    
    public Node getParent() 
    {
        return parent;
    }
    
}
