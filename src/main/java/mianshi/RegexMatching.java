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
            // 被匹配的字符是* 向左取两个
            if (pattern[i - 1] == '*') {
                matrix[0][i] = matrix[0][i - 2];
            }
        }

        // 遍历所有行
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    // . 匹配任意字符 即与任意text中的字符匹配 || pattern中的字符与text中的字符相等 ,取值 左上方的值
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    // 匹配到* 取值 左边偏移2的值
                    matrix[i][j] = matrix[i][j - 2];
                    if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]) {
                        // 匹配到* 并且 左边一个的pattern字符与text中的字符相等 || pattern字符为.(.匹配任意字符) ,取值 上方的值为true 则为true
                        matrix[i][j] = matrix[i][j] | matrix[i - 1][j];
                    }
                } else {
                    // 不相等 pattern既不是.也不是*
                    matrix[i][j] = false;
                }
            }
        }
        // 返回最终匹配的结果
        return matrix[text.length][pattern.length];
    }
}
