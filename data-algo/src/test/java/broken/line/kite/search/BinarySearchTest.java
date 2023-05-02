package broken.line.kite.search;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author: wanjia1
 * @date: 2023/5/2
 */
class BinarySearchTest {

    private static int bsFindLocalMin(int[] arr) {
        if (Objects.isNull(arr) || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        // 到这里 数组长度一定大于2
        if (arr[arr.length - 2] > arr[arr.length - 1]) {
            return arr.length - 1;
        }
        int left = 0;
        int right = arr.length - 1;
        //注意数组越界问题 为啥-1 因为最后要两个数 判断 否则会出现left 0 right 1 会出现问题 {65 9 154 62 27 145 39 91 7 95 126}
        while (left < right - 1) {
            int mid = left + ((right - left) >> 1);
            if ((arr[mid - 1] > arr[mid]) && (arr[mid] < arr[mid + 1])) {
                return mid;
            } else {
                if (arr[mid - 1] < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return arr[left] < arr[right] ? left : right;
    }


    // 生成随机数组，且相邻数不相等
    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    // 也用于测试
    public static boolean check(int[] arr, int minIndex) {
        try {
            if (arr.length == 0) {
                return minIndex == -1;
            }
            int left = minIndex - 1;
            int right = minIndex + 1;
            boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
            boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
            return leftBigger && rightBigger;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxLen = 100;
        int maxValue = 200;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int ans = -1;
            try {
                ans = bsFindLocalMin(arr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!check(arr, ans)) {
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束");

    }

    @Test
    void should_test_find() {
        int[] arr = {1, 2, 3};
        int num = 3;
        int index = bs(arr, num);

    }

    private int bs(int[] arr, int num) {
        // 缺少边界条件 arr.length == 0
        if (Objects.isNull(arr) || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // arr有序的，>=num 最左
    @Test
    void findNearLeft() {
        int[] arr = {1, 2, 3};
        int num = 3;
        int index = bsNearLeft(arr, num);
    }

    private int bsNearLeft(int[] arr, int num) {
        int index = -1;
        if (arr == null || arr.length == 0) {
            return index;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= num) {
                index = mid;
                right = mid - 1;
            } else {
                right = mid + 1;
            }

        }
        return index;
    }

    // 在arr上，找满足<=value的最右位置
    @Test
    void findNearRight() {

        int[] arr = {1, 2, 3};
        int num = 3;
        int index = bsNearRight(arr, num);
    }

    private int bsNearRight(int[] arr, int num) {
        int index = -1;
        if (arr == null || arr.length == 0) {
            return index;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= num) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    // 局部最小值问题 不相等数组
    @Test
    void findLocalMin() {
        int[] arr = {1, 2, 3};
        int index = bsFindLocalMin(arr);
    }
}