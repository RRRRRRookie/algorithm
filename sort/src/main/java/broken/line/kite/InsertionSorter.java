package broken.line.kite;

import java.util.Objects;

/**
 * @author: wanjia1
 * @date: 2023/4/30
 */
public class InsertionSorter {

    public static void sort(int[] arr) {
        if (Objects.isNull(arr) || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = i; j > 0 && arr[j] > arr[j + 1]; j--) {
                SortUtils.swap(arr, j, j + 1);
            }
        }

    }

}
