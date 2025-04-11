package TREENODE;


public class TreeNode{
	int val;
	TreeNode left, right;

public TreeNode(int val){
		this.val = val;
		this.left=this.right=null;
	}

  public int getVal(){
      return val;
  }

  public void setVal(int val){
      this.val = val;
  }
  public TreeNode getLeft(){
      return left;
  }
  public TreeNode getRight(){
      return right;
  }
  public void setLeft(TreeNode left){
      this.left = left;
  }
  public void setRight(TreeNode right){
      this.right = right;
  }
}
