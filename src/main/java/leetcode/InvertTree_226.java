package leetcode;

/**
 * Created by wangshunxi on 2020/4/28.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
//翻转一棵二叉树
public class InvertTree_226 {
    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}


