package mianshi;

/**
 * @author wangshunxi
 * @since 2020/3/8.
 * 什么是KMP算法?
 * 由D.E.Knuth，J.H.Morris和V.R.Pratt提出的
 * KMP算法的核心是利用匹配失败后的信息，
 * 尽量减少模式串与主串的匹配次数以达到快速匹配的目的。
 * 具体实现就是通过一个next()函数实现，
 * 函数本身包含了模式串的局部匹配信息。
 * m代表模式串的长度,n代表主串的长度
 * KMP算法的时间复杂度O(m+n)。
 * KMP算法的空间复杂度O(m)。
 */
public class Kmp {

    public static void main(String[] args) {
        String str = "ATGTGAGCTGGTGTGTGCFAA";
        String pattern = "GTGTGCF";
        int index = kmp(str, pattern);
        System.out.println("首次出现位置：" + index);
    }

    /**
     *
     * @param str 主串
     * @param pattern 模式串 待匹配的字符串
     * @return
     */
    public static int kmp(String str, String pattern) {
        //预处理，生成next数组
        int[] next = getNext(pattern);
        int j = 0;
        //主循环，遍历主串字符
        for (int i = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
                //遇到坏字符时，查询next数组并改变模式串的起点
                j = next[j];
            }
            if (str.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                //匹配成功，返回下标
                return i - pattern.length() + 1;
            }

        }
        return -1;
    }

    /**
     * 生成Next数组
     *
     * @param pattern
     * @return
     */
    private static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;
        for (int i = 2; i < pattern.length(); i++) {
            while (j != 0 && pattern.charAt(j) != pattern.charAt(i - 1)) {
                //从next[i+1]的求解回溯到 next[j]
                j = next[j];
            }
            if (pattern.charAt(j) == pattern.charAt(i - 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


}
