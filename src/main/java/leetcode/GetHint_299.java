package leetcode;

/**
 * Created by wangshunxi on 2020/4/20.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class GetHint_299 {
    public static void main(String[] args) {

    }

    public String getHint(String secret, String guess) {
        int len = secret.length();
        int A = 0;//公牛数量
        int B = 0;//母牛数量
        char[] c1 = new char[10]; //secret 中不是公牛数量
        char[] c2 = new char[10]; //guess 中不是公牛数量
        char[] sc = secret.toCharArray();
        char[] gs = guess.toCharArray();
        for (int i = 0;i < secret.length();i++){
            if (sc[i] == gs[i]) {
                A++;
            }else {
                int i1 = sc[i] - '0';
                int i2 = gs[i] - '0';
                c1[i1]++;
                c2[i2]++;
            }

        }
        for (int i = 0;i < 10;i++){
            //取两者重叠部分
            B += Math.min(c1[i],c2[i]);
        }
        return A+"A"+B+"B";
    }

}
