package broken.line.kite.functional;

/**
 * @author: wanjia1
 * @date: 2023/5/1
 */
public class Factorial {

    public static int factorialCount(int num) {
        int cursor = 1;
        int count = 0;
        for (int i = 1; i < num + 1; i++) {
            cursor *= i;
            count += cursor;
        }
        return count;
    }

    public static int factorial(int num) {
        int ans = 1;
        for (int i = 1; i < num + 1; i++) {
            ans *= i;
        }
        return ans;
    }


}
