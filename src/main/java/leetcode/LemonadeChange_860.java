package leetcode;

/**
 * Created by wangshunxi on 2020/5/7.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class LemonadeChange_860 {
    public static void main(String[] args) {

    }
    public static boolean lemonadeChange(int[] bills){
        int five = 0;
        int ten = 0;
        for (int bill:bills) {
            switch (bill){
                case 5:five++;break;
                case 10:five--;ten++;break;
                case 20:{
                    if (ten > 0){
                        ten--;five--;
                    }else {
                        five -= 3;
                    }
                    break;
                }
                default:break;
            }
            if (five < 0){
                return false;
            }
        }
        return true;
    }
}
