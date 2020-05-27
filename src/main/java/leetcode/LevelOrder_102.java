package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangshunxi on 2020/5/11.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class LevelOrder_102 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder (TreeNode root){
        if (root == null) return new ArrayList<List<Integer>>();
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() > 0){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0;i < size;++i){
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null){
                    queue.add(t.right);
                }

            }
            res.add(tmp);
        }
        return res;
    }
}
