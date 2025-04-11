package Recursive;


import TREENODE.TreeNode;
import java.util.List;
import java.util.ArrayList;

public class InOrderTraversal{
    public static void main(String [] args){
        TreeNode root = new TreeNode(1);
        root.setRight(new TreeNode(2));
        root.getRight().setLeft(new TreeNode(3));
       
        List<Integer> list = new ArrayList<>();
        list = inOrderTraversal(root);
        System.out.print(list);

    }
    public static List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inOrder(list,root);
        return list;
    }
    public static void inOrder(List<Integer> list, TreeNode root){
        if(root==null)return;
        
        inOrder(list,root.getLeft());
        list.add(root.getVal());
        inOrder(list,root.getRight());
    }
}
