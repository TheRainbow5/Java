package Lambda;

/**
 * Rainbow
 * 使用lambda表达式
 * 如果一个接口只有一个抽象方法，就是函数时接口
 * 此时，可以使用lambda表达式快速实现方法
 *
 * @DATE:2023/9/18 0018
 */
public class demo {
    public static void main(String[] args) {
        //lambda表达式实现接口
        InterfaceTest test = () -> {
            System.out.println("lambda表达式");
            System.out.println("I am lambda");
        };
        test.testLambda();
    }
}

interface InterfaceTest {
    void testLambda();    //只有一个抽象方法
}
