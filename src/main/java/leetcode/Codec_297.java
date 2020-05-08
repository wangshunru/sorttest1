package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangshunxi on 2020/5/8.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class Codec_297 {
    public static void main(String[] args) {

    }
    //二叉树的序列化
    public static String serialize(TreeNode root){
        StringBuilder ans = ser_core(root, new StringBuilder());
        return ans.toString();
    }
    private static StringBuilder ser_core(TreeNode root,StringBuilder s){
        if (root == null){
            s.append("null,");
            return s;
        }
        s.append(root.val+",");
        s = ser_core(root.left, s);
        s = ser_core(root.right, s);
        return s;
    }
    //二叉树的反序列化
    public static TreeNode deserialize(String s){
        String[] split = s.split(",");
        LinkedList<String> list = new LinkedList<String>(Arrays.asList(split));
        return desc_core(list);
    }
    private static TreeNode desc_core(List<String> ss){
        if (ss.get(0).equals("null")){
            ss.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(ss.get(0)));
        ss.remove(0);
        node.left = desc_core(ss);
        node.right = desc_core(ss);
        return node;
    }
}

