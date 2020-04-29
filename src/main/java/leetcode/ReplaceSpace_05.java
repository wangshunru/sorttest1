package leetcode;

/**
 * Created by wangshunxi on 2020/4/29.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class ReplaceSpace_05 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length;i++){
            if (chars[i] == ' '){
                sb.append("%20");
            }else{
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
