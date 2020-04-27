package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshunxi on 2020/4/25.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
//二叉树的中序遍历  左根右
public class InorderTraversal_94 {

    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }

    public static void helper(TreeNode root,List<Integer> res){
        if (root != null){
            if (root.left != null){
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null){
                helper(root.right,res);
            }
        }
    }
}
class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int x){
        val = x;
    }
}
