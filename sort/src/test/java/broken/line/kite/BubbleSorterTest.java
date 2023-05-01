package broken.line.kite;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author: wanjia1
 * @date: 2023/5/1
 */
@Slf4j
class BubbleSorterTest {

    public static void sort(int[] arr) {
        if (Objects.isNull(arr) || arr.length < 2) {
            return;
        }
        int last = arr.length - 1;
        for (int i = last; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    @Test
    void test_sort() {
        SortUtils.test(100000, 1000, 1000, BubbleSorterTest::sort);
//        int[] arr = {358, -400, -555, 27, -436, 459, -851, 217, 727, 428, 783, 486, -543, -381, 102, 153, 449, 0, -516, -239, 325, 313, 241, -14, 654, -430, 304, 33, -12, -545, 77, -103, 764, -8, -669, -227, -102, 812, -16, 10, 938, 373, 575, -66, 611, -540, 332, -130, 591, 332, -371, -262, -636, -163, -302, 527, 10, 854, 448, 40, -257, -605, -806, 200, -923, -273, 207, -698, 438, -164, -139, 543, 71, -411, 263, 153, 101, -52, 187, -492, 568, -449, 189, 538, 295, 37, 691, -210, 0};
//        sort(arr);
//        log.info(Arrays.toString(arr));
    }
}