package Syn;

/**
 * Rainbow
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

    @Override
    public void run() {
        while (flag) {
            Buy();
        }
    }

    //判断是否有票
    private synchronized void Buy() {
        if (tickets <= 0) {
            flag = false;
            return;
        }
        //买票
        System.out.println(Thread.currentThread().getName() + "拿到" + tickets--);
    }
}
