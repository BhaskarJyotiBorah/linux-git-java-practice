
import java.util.Stack;


public class PreOrderIterative{
	public static void main(String [] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

               preOrderIterative(root);
	       System.out.println();

	}

	public static void preOrderIterative(TreeNode root){
                  
		Stack<TreeNode> stack = new Stack<>();

		stack.push(root);

		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			System.out.print(node.val+" ");

			if(node.right!=null)stack.push(node.right);
			if(node.left!=null)stack.push(node.left);
		
		}
		
	}
}
