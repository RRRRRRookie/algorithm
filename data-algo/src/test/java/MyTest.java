import org.junit.jupiter.api.Test;

/**
 * @author: wanjia1
 * @date: 2023/5/1
 */
public class MyTest {

    @Test
    void test1() {
        int i = 9;
        System.out.println(i--);
        int j = 9;
        System.out.println(--j);
    }

    @Test
    void test2() {
        int i = 170 % 64;
        int j = 170 & 63;
        System.out.println(i + "  " + j);

    }

    @Test
    void test3() {
        int num = 3;
        // -3
        System.out.println((~num) + 1);
        // 取反符号位是反的 -4
        System.out.println(~num);
        // 1
        System.out.println(3 & -3);
    }

    @Test
    void test4() {
        // 溢出会变成负数
        int num = (Integer.MAX_VALUE - 1) * 2;
        System.out.println(num);
    }

}
