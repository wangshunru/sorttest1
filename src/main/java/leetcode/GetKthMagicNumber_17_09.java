package leetcode;

/**
 * Created by wangshunxi on 2020/4/27.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class GetKthMagicNumber_17_09 {
    public static void main(String[] args) {

    }
    public int getKthMagicNumber(int k) {
        int[] res = new int[k];
        int p3 = 0,p5 = 0,p7 = 0;
        res[0] = 1;
        for (int i = 1;i < k;i++){
            res[i] = Math.min(res[p3]*3,Math.min(res[p5]*5,res[p7]*7));
            if (res[i] == res[p3]*3) p3++;
            if (res[i] == res[p5]*5) p5++;
            if (res[i] == res[p7]*7) p7++;
        }
        return res[k-1];
    }
}
