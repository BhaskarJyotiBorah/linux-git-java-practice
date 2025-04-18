public class InOrderRecursive{
	public static void main(String [] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		inOrderRecursive(root);
		System.out.println();

	}
	public static void inOrderRecursive(TreeNode root){
		if(root==null)return;

		inOrderRecursive(root.left);
		System.out.print(root.val+" ");
		inOrderRecursive(root.right);
	}
}
