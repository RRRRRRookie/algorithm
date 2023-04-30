package broken.line.kite;

import java.util.Objects;

/**
 * @author: wanjia1
 * @date: 2023/4/17
 */
public class SelectSorter {


    public static void selectSort(int[] arr) {
        if (Objects.isNull(arr) || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int cursor = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[cursor] > arr[j]) {
                    cursor = j;
                }
            }
            SortUtils.swap(arr, cursor, i);
        }

    }



    public static void main(String[] args) {
        int[] arr = {100, 67, 2, 55, 2399, 123};
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
