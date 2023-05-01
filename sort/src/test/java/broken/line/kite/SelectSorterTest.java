package broken.line.kite;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author: wanjia1
 * @date: 2023/5/1
 */
class SelectSorterTest {

    public static void sort(int[] arr) {
        if (Objects.isNull(arr) || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            SortUtils.swap(arr, minIndex, i);
        }
    }

    @Test
    void test_sort() {
        SortUtils.test(500000, 1000, 1000, SelectSorterTest::sort);
    }
}