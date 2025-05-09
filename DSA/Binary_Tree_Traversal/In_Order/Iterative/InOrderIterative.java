
import java.util.Stack;


public class InOrderIterative{
	public static void main(String [] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.print("In-Order Tree Traversal: ");
		inOrderTraversal(root);

	}
	public static void inOrderTraversal(TreeNode root){
		if(root==null)return;

		Stack<TreeNode> stack = new Stack<>();
                
		TreeNode current = root;

		while(current!=null || !stack.isEmpty()){

			while(current!=null){
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			System.out.print(current.val+" ");

			current = current.right;
		        
		}
	}
}
