package broken.line.kite;

/**
 * @author: wanjia1
 * @date: 2023/4/30
 */
public class SortUtils {

    static void swap(int[] arr, int cursor, int i) {
        int temp = arr[cursor];
        arr[cursor] = arr[i];
        arr[i] = temp;
    }

    static void bitwiseSwap(int[] arr, int cursor, int i) {
        arr[cursor] = arr[cursor] ^ arr[i];
        arr[i] = arr[cursor] ^ arr[i];
        arr[cursor] = arr[cursor] ^ arr[i];
    }

}
