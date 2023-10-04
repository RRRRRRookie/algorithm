package broken.line.kite.rookie.class02;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 求对指定数据 [L,R的累加和]
 * 三种解决方案
 * 实时计算 N次 构建N/A 查询O(N)
 * 将所有结果预计算出来 构建n^2/2的数组 查询O(0) 构建O(N^2)
 * 使用前缀和数组 经过O(1)查询 构建O(N)
 * 正常方案构建一个n*n的数组 构建复杂度为N^2 大概为N^2/2 但超大规模的查询 来说这种情况更好
 * 我们使用前缀和数组来解决该问题 将非线性增长的时间复杂度改为线性增长的
 * 构建辅助数组
 * help[]
 * help[0] = arr[0]
 * help[1] = arr[0] + arr[1]
 * help[n-2] = arr[0] + ....... arr[n-2]
 * help[n-1] = arr[0] + ....... arr[n-2] + arr[n-1]
 * 当你求一个数据和的时候
 * sum arr [0,3) help[3]
 * sum arr [0,n) help[n]
 * sum arr [i,j) help[j] - help[i]
 *
 * @author: wanjia1
 * @date: 2023/10/4
 */
@Slf4j
public class PreSum {


    public static void main(String[] args) {

    }

    @Getter
    @Setter
    public static class PreSumBuilder {
        private int[] help;

        public PreSumBuilder(int[] arr) {
            this.help = buildArr(arr);
        }

        private int[] buildArr(int[] arr) {
            // special case arr is null
            int length = arr.length;
            int[] result = new int[length];
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    result[i] = arr[i];
                } else {
                    result[i] = result[i - 1] + arr[i];
                }
            }
            return result;
        }

        public long rangLR(int L, int R) {
            // special case
            if (L == 0) {
                return help[R];
            }
            return help[R] - help[L - 1];
        }
    }

}
