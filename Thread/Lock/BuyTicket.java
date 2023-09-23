package Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Rainbow
 * 使用Lock锁
 *
 * @DATE:2023/9/18 0018
 */
public class BuyTicket {
    public static void main(String[] args) {
        BuyTickets buyTickets = new BuyTickets();

        new Thread(buyTickets, "张三").start();
        new Thread(buyTickets, "李四").start();
        new Thread(buyTickets, "王五").start();
    }
}

class BuyTickets implements Runnable {
    private static int tickets = 10;  //票数
    boolean flag = true;
    private final ReentrantLock lock = new ReentrantLock();  //创建lock

    @Override
    public void run() {
        while (flag) {
            try {
                lock.lock();     //开启锁
                if (tickets <= 0) {
                    flag = false;
                    return;
                }
                Thread.sleep(200);
                //买票
                System.out.println(Thread.currentThread().getName() + "拿到" + tickets--);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();    //释放锁
            }
        }
    }
}
