package Abstract;

/**
 * Rainbow
 * 抽象类
 * @DATE:2023/9/17 0017
 */
public class demo {
    public static void main(String[] args) {


    }
}
abstract class Parent{   //抽象类
    String name="rainbow";
    public void eat(){
        System.out.println("吃东西");   //普通方法
    }
    public abstract void hello();   //抽象方法没有方法体
}

