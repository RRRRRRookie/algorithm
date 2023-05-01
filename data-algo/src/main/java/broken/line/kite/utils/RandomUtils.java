package broken.line.kite.utils;

/**
 * @author: wanjia1
 * @date: 2023/5/1
 */
public class RandomUtils {

    public static int getRandomLength(int maxLength) {
        return (int) ((maxLength + 1) * Math.random());
    }

    public static int getRandomByMax(int max) {
        return ((int) ((max + 1) * Math.random())) - ((int) (max * Math.random()));
    }


}
