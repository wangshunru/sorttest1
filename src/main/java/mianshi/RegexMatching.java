package mianshi;

/**
 * @author wangshunxi
 * @since 2020/3/15.
 */
public class RegexMatching {

    public static void main(String[] args) {
        RegexMatching rm = new RegexMatching();
        boolean match = rm.matchRegex("abbc".toCharArray(),"ab*c".toCharArray());
        System.out.println(match);
    }

    private boolean matchRegex(char[] text, char[] pattern) {
        // 匹配结果存储变量boolean[i][j]  i=0 j=0 都为false
        boolean[][] matrix = new boolean[text.length + 1][pattern.length + 1];
        // 设置原点为true 空匹配空
        matrix[0][0] = true;
        // 匹配第0行
        for (int i = 1; i < matrix[0].length; i++) {
            // 被匹配的字符是* 向前取两个
            if (pattern[i - 1] == '*') {
                matrix[0][i] = matrix[0][i - 2];
            }
        }

        // 遍历所有行
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    // 匹配到. 或 字符相等 ij的值 取 i-1 j-1的值
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    // 匹配到* 向前取两个
                    matrix[i][j] = matrix[i][j - 2];
                    if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]) {
                        // 前一个为. 或 字符相等 当前值与前一个有一个为true就是true
                        matrix[i][j] = matrix[i][j] | matrix[i - 1][j];
                    }
                } else {
                    matrix[i][j] = false;
                }
            }
        }
        return matrix[text.length][pattern.length];
    }
}
