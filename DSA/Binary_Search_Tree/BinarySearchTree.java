public class BinarySearchTree{
    Node root; //Instance variable will be created on creating the BinarySearchTree

    public BinarySearchTree(){
        this.root = null;            //Default constructor will be created marking root = null;
    }

    void insert(int key){
        root = insertRecursive(root,key); //root helps in Traversal
    }

    Node insertRecursive(Node root, int key){
        
        if(root == null){    //Recursive base case
            root = new Node(key);
            return root;
        }

        if(key<root.key){
            root.left = insertRecursive(root.left,key); //If given key smaller than the node's we go to left Node and repeat process
        }else if(key>root.key){
            root.right = insertRecursive(root.right,key); //If given key greater than the node's we go to right Node and repeat process
        }

        return root;
                     
                      
    }


    void delete(int key){
        root = deleteRecursive(root,key);
    }

    Node deleteRecursive(Node root, int key){
        if(root == null){
            return root; //if root == null return null or itself
        }

        if(key<root.key){
            root.left = deleteRecursive(root.left, key); //if key is less than root's key we go to the left subtree
        }else if (key>root.key){
            root.right = deleteRecursive(root.right,key); // if key is greater than root's key we go to the right subtree
        }else{

            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }

            root.key = minVal(root.right); // we are doing in Order succession method. so we find the smallest value from the right subtree
            root.right = deleteRecursive(root.right,root.key);            

        }

        return root;
    }
    
    int minVal(Node root){
        int min = root.key;
        while(root.left!=null){ //Searches the smallest value in the current subtree
            min = root.left.key;
            root = root.left;
        }
        return min;
    }


    void print(){
        
        inOrderTraversal(root);
    }

   

    void inOrderTraversal(Node root){ //In-Order Traversal
       if(root == null) return;

       inOrderTraversal(root.left);
       System.out.println(root.key);
       inOrderTraversal(root.right);
    }

    public static void main (String [] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(25);
        bst.insert(10);
        bst.insert(40);
        bst.insert(5);
        bst.insert(20);
        bst.insert(15);
        bst.insert(21);
        bst.insert(16);

        bst.print();

        bst.delete(10);
        System.out.println("Deleted : "+10);
        System.out.println();
        
        bst.print();
    }

}
