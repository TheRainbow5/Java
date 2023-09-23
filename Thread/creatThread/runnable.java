package creatThread;

/**
 * Rainbow
 * 实现Runnable接口，创建多线程
 *
 * @DATE:2023/9/17 0017
 */
public class runnable implements Runnable {
    private int tickets = 10;

    @Override
    public void run() {
        while (true) {
            if (tickets <= 0)
                break;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "抢到第" + tickets-- + "票");
        }
    }

    public static void main(String[] args) {
        //创建Runnable实现类对象
        runnable ra = new runnable();
        //方便同一个对象被多个线程使用（并发）
        new Thread(ra, "小明").start();
        new Thread(ra, "张三").start();
        new Thread(ra, "李四").start();
    }
}
