import java.util.Stack;

public class PostOrderTraversal{
	public static void main(String [] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.left = new TreeNode(7);

		postOrderTraversal(root);
		System.out.println();


	}
	public static void postOrderTraversal(TreeNode root){
		if(root==null)return;

		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> out = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()){
			TreeNode current = stack.pop();
			out.push(current);

			if(current.left!=null) stack.push(current.left);
			if(current.right!=null) stack.push(current.right);

		}

		while(!out.isEmpty()){
			System.out.print(out.pop().val+" ");
		}

		
	}
}
