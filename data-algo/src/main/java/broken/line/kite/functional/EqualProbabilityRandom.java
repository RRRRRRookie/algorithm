package broken.line.kite.functional;

/**
 * @author: wanjia1
 * @date: 2023/5/1
 */
public class EqualProbabilityRandom {

//    如何用1~5的随机函数加工出1~7的随机函数
//
//    如何用a~b的随机函数加工出c~d的随机函数
//
//    如何把不等概率随机函数变成等概率随机函数


    public static int random5() {
        return ((int) Math.random() * 5) + 1;
    }

    public static int random01(RandomBox randomBox) {
        // TODO
        int max = randomBox.max;
        int min = randomBox.min;
        return 0;
    }

    public static class RandomBox {
        int max;
        int min;

        public RandomBox(int mi, int ma) {
            min = mi;
            max = ma;
        }

        public int random() {
            return min + (int) (Math.random() * (max - min + 1));
        }

        public int min() {
            return min;
        }

        public int max() {
            return max;
        }

    }


}
