package leetcode;

/**
 * Created by wangshunxi on 2020/4/28.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
public class IsValidBST_98 {
    public static void main(String[] args) {

    }
    public static boolean isValidBST(TreeNode root){
        return _generare(root,null,null);
    }
    //使用TreeNode 本身做上下界
    public static boolean _generare(TreeNode node,TreeNode min,TreeNode max){
        if (node == null) return true;
        if (min != null && node.val <= min.val) return false;
        if (max != null && node.val >= max.val) return false;
        return _generare(node.left, min, node) && _generare(node.right, node, max);
    }
}
