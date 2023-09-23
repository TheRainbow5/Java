package Abstract;

/**
 * Rainbow
 * 抽象类实现设计模式-模板模式
 *
 * @DATE:2023/9/17 0017
 */
public class TemplateMode {
    public static void main(String[] args) {
        A a = new A();
        a.calculateTime();   //直接调用父类的方法

        B b = new B();
        b.calculateTime();
    }
}

abstract class calculateTimeTemplate {
    public abstract void job();    //定义抽象方法

    public void calculateTime() {
        long startTime = System.currentTimeMillis();   //开始时间
        job();      //各个类执行的任务
        long endTime = System.currentTimeMillis();   //结束时间
        System.out.println("任务执行了" + (endTime - startTime) + "秒");
    }
}

class A extends calculateTimeTemplate {
    @Override
    public void job() {
        int num = 0;
        for (int i = 0; i <= 800000; i++) {
            num += i;
        }
    }
}

class B extends calculateTimeTemplate {
    public void job() {
        int num = 0;
        for (int i = 0; i < 600000; i++) {
            num += i;
        }
    }
}
