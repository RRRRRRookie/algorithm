package broken.line.kite.bitwise.operation.nor;

import org.junit.jupiter.api.Test;

/**
 * @author: wanjia1
 * @date: 2023/5/2
 */
class SwitchTest {


    @Test
    void printOddTimesNum2() {
        int[] arr = {1, 1, 2, 3};

        find(arr);


    }

    private void find(int[] arr) {
        // TODO 边界条件 异常条件
        int merge = 0;
        for (int i = 0; i < arr.length; i++) {
            merge ^= arr[i];
        }

        int rightOne = merge & (-merge);
        int current = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((rightOne & arr[i]) != 0) {
                current ^= arr[i];
            }
        }
        System.out.println(current + "  " + (current ^ merge));
    }

    @Test
    void bitCounts() {

        int count = findCounts(5);
    }

    private int findCounts(int i) {
        int count = 0;
        while (i != 0) {
            int rightOne = i & -i;
            i ^= rightOne;
            count++;
        }
        return count;
    }
}