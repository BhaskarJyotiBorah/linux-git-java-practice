OBJECTIVE: Implement Binary Search Tree with Insertion, deletion and Search Operation

Procedure:
Node Class:
1. I created a Node class containing a int value "key" and two pointers of Node type.
2. In the constructor, the key is passed which is then stored in our instance variable. And initialized left and right pointers to null

BinarySearchTree Class:
1. Created an instance of root and created a default constructor to initialze the root = null;
2. Insertion: 
   2.1 we created a void method. which stores the root = deleteRecursive(root,key); 

   2.2 insertRecursive(Node root, key) : 1. This methods adds keys to the BST by examining the left and right node's key. 
                                         2. if the root == null then we just need to create a new node in root and place the key. (root = new Node(key));
                                         3. if not we compare with the left and the right values of the nodes and place the key in the suitable position.
3. Deletion:
    3.1 First Created the void delete method which calls deleteRecursive(Node root, int key); and stores that in root.
    3.2 deleteRecursive(Node root, key): 
           1. First we check if root == null, if yes we return root or null;
           2. If Not we compare and find move on till we find the key that we want to delete.
           3. when we find the root whose key == target key. we use "In order successive method" to delete this.
           4. First we check if its left node is null, if its null we are going to return the right Node and vice-versa
           5. If not then we calculate the minimum value in the right subtree.
           6. For that we pass our root.right(right subtree's root) to minVal method which evaluates the minimum value and returns it, which replaces the Target Node.
           7. After that we move on and check a special case of inOrder succession that is when there exist a child of smallest value to its right. To check this we further do one more recursive call where root.right = deleteRecursive(root.right, root.key).
           8. If this condition arises, we replace the smallest value with the child value. Thus maintaining the BST order
           9. Finally we return the root.
4. Search: 
   4.1 compare left and right keys and move on till we find our target value.

5. Traversal: We use In-Order Traversal
   1. In-Order Traversal in BST produces keys in ascending Order
