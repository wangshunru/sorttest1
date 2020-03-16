package mianshi;

/**
 * @author wangshunxi
 * @since 2020/3/16.
 * 用于解决给定区间最值问题查询
 * 提前预处理构建n*(log(n)+1) -->n*log(n)的Sparse Table 可以实现时间复杂度O(1)的快速检索
 */
public class SparseTable {


    public static void main(String[] args) {
        SparseTable st = new SparseTable();
        int[] input = new int[]{4,6,1,5,7,3};
        int[][] sparseTable = st.preProcess(input, input.length);
        // 求索引 1 - 6 中最小值 i=1 log(6)
        int begin = 2;
        int end = 5;
        int min = getMin(input,sparseTable, begin, end);
        System.out.println(min);

    }

    private static int getMin(int[] input,int[][] sparseTable, int low, int high) {
        // 已知 i,i+Math.pow(2,j)-1 为 low,high 求 j; Math.pow(2,j) -1 = end - begin ;j=(Math.log(end - begin + 1) / Math.log(2))
        int l = high - low + 1;
        int k = (int) (Math.log(l) / Math.log(2));
        // 这样 low + Math.pow(2,k)-1 小于high ; high + 1 - Math.pow(2,k) 大于 low 两个区间的最小值即为low,high区间的最小值
        return Math.min(input[sparseTable[low][k]],input[sparseTable[(int) (low+ l- (Math.pow(2,k)))][k]]);
    }

    private int[][] preProcess(int[] input, int n) {
        int l = (int) (Math.log(n) / Math.log(2)) + 1;
        int[][] sparseTable = new int[n][l];
        // i,j 对应闭区间 f(i,i+Math.pow(2,j)-1)
        // 找到初始值 j = 0  区间 i,i+Math.pow(2,0)-1 即 i,i 值为索引下标
        for (int i = 0; i < n; i++) {
            sparseTable[i][0] = i;
        }
        // 在有初始值的情况下 逐步迭代
        for (int j = 1; j<l; j++) {
            for (int i = 0; i + Math.pow(2, j) - 1 < n; i++) {
                if ((input[sparseTable[i][j - 1]]) <= input[sparseTable[(int) (i + Math.pow(2, (j - 1)))][j - 1]]) {
                    sparseTable[i][j] = sparseTable[i][j - 1];
                } else {
                    sparseTable[i][j] = sparseTable[(int) (i + Math.pow(2, (j - 1)))][j - 1];
                }
            }
        }
        return sparseTable;
    }
}
