package leetcode;

/**
 * Created by wangshunxi on 2020/4/25.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class DiameterOfBinaryTree_543 {
    public static void main(String[] args) {

    }
    private static int res = 0;
    public static int diameterOfBinaryTree(TreeNode root){
        helper(root);
        return res;
    }
    private static int helper(TreeNode root){
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(res,left+right);
        return Math.max(left,right)+1;
    }
}
