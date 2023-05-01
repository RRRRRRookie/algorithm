package broken.line.kite;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author: wanjia1
 * @date: 2023/4/30
 */
@Slf4j
public class SortUtils {

    public static void swap(int[] arr, int cursor, int i) {
        int temp = arr[cursor];
        arr[cursor] = arr[i];
        arr[i] = temp;
    }

    public static void bitwiseSwap(int[] arr, int cursor, int i) {
        arr[cursor] = arr[cursor] ^ arr[i];
        arr[i] = arr[cursor] ^ arr[i];
        arr[cursor] = arr[cursor] ^ arr[i];
    }

    public static void test(int times, int maxValue, int arrayLength, Consumer<int[]> consumer) {
        for (int i = 0; i < times; i++) {
            int[] arr = generateRandomArray(maxValue, arrayLength);
            int[] copyOne = copy(arr);
            int[] copyTwo = copy(arr);
            Arrays.sort(copyOne);
            consumer.accept(copyTwo);
            for (int j = 0; j < arr.length; j++) {
                if (notEqual(copyOne, copyTwo)) {
                    log.info(Arrays.toString(arr));
                    return;
                }
            }
        }
    }

    private static boolean notEqual(int[] copyOne, int[] copyTwo) {
        if ((Objects.isNull(copyOne) && Objects.nonNull(copyTwo)) || (Objects.isNull(copyTwo) && Objects.nonNull(copyOne))) {
            return true;
        }
        if ((Objects.isNull(copyOne) && (Objects.isNull(copyTwo)))) {
            return false;
        }
        if (copyOne.length != copyTwo.length) {
            return true;
        }

        for (int i = 0; i < copyOne.length; i++) {
            if (copyOne[i] != copyTwo[i]) return true;
        }

        return false;
    }

    private static int[] copy(int[] arr) {
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    private static int[] generateRandomArray(int maxValue, int arrayLength) {
        // random [0,1) -> [0,maxValue +1) -> [0,maxValue]
        int randomLength = (int) (Math.random() * (arrayLength + 1));
        int[] arr = new int[randomLength];
        for (int i = 0; i < randomLength - 1; i++) {
            // 同时返回正负值 (-maxValue , maxValue]
            arr[i] = ((int) (Math.random() * (maxValue + 1))) - ((int) (Math.random() * maxValue));
        }
        return arr;
    }

}
