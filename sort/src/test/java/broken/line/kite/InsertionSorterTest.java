package broken.line.kite;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author: wanjia1
 * @date: 2023/5/1
 */
class InsertionSorterTest {

    public static void sort(int[] arr) {
        if (Objects.isNull(arr) || arr.length < 2) {
            return;
        }

        // ❌ 1 i < arr.length - 1 > i < arr.length
        for (int i = 1; i < arr.length; i++) {
            // ❌ 1 i < arr.length - 1 > i < arr.length
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                SortUtils.swap(arr, j, j + 1);
            }
        }
    }

    @Test
    void test_sort() {
//        int[] arr = {523, -81, -642, -463, 215, -620, -645, 245, 458, -109, -517, 206, -342, 268, 573, 53, 260, 26, -113, -187, 0};
//        sort(arr);
//        Arrays.stream(arr).forEach(System.out::println);
        SortUtils.test(500000, 1000, 1000, InsertionSorterTest::sort);
    }

}