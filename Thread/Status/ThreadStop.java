package Status;

/**
 * Rainbow
 * 线程暂停
 * 1、建议线程正常停止
 * 2、建议使用标志位，实现线程停止
 * 3、不建议使用stop或者destory等过时的方法
 *
 * @DATE:2023/9/18 0018
 */
public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
        God god = new God();
        Person person = new Person();
        //创建上帝线程
        Thread godThread = new Thread(god);
        godThread.setDaemon(true);   //设置为守护线程
        godThread.start();

        //创建用户线程
        Thread personThread = new Thread(person);
        personThread.start();
    }
}

class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("正在执行守护线程");
        }
    }
}

class Person implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("用户岁数=" + i);
        }
        System.out.println("======say goodbye======");
    }
}

