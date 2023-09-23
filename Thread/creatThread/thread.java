package creatThread;

/**
 * Rainbow
 * 创建多线程
 * 通过继承Thread类实现多线程
 *
 * @DATE:2023/9/17 0017
 * 总结：线程开启不一定立即执行，而是由CPU决定。
 */
public class thread extends Thread {
    @Override
    public void run() {   //run线程
        for (int i = 0; i < 200; i++) {
            System.out.println("这是run线程，num=" + i);
        }
    }

    public static void main(String[] args) {
        //创建一个线程对象
        thread dem = new thread();
//        dem.run();        //run()方法则是按顺序执行
        dem.start();      //多个线程同时交替执行


        for (int i = 0; i < 500; i++) {
            System.out.println("这是main线程，num=" + i);
        }
    }
}

