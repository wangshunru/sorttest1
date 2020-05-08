package leetcode;

/**
 * Created by wangshunxi on 2020/4/28.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class LowestCommonAncestor_236 {
    public static void main(String[] args) {

    }
    private static TreeNode res;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }


    private boolean contains(TreeNode x, TreeNode p, TreeNode q){
        if(x == null) return false;
        boolean leftCon = contains(x.left, p, q);
        boolean rightCon = contains(x.right, p, q);
        /*
        * x == p 且 q 在右子树
        * x == q 且 p 在左子树
        * x == p 且 q 在左子树
        * x == q 且 p 在右子树
        * p q 分别在左右子树
        * */
        if((x == p && rightCon) || (x == q && leftCon) || (x == p && leftCon)|| (x == q && rightCon) ||(leftCon && rightCon)) {
            res = x;
            return true;
        }
        return x == p || x == q || leftCon || rightCon;
    }
}
