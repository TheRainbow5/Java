package creatThread;

import lombok.SneakyThrows;

/**
 * Rainbow
 * 多线程模拟龟兔赛跑
 *
 * @DATE:2023/9/17 0017
 */
public class Race implements Runnable {
    private static String winner;

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            //判断比赛是否结束
            if (gameOver(i)) {
                break;
            } else {
                System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
            }
            //兔子每次跑10步休息
            if (Thread.currentThread().getName().equals("rabbit") && i == 10) {
                System.out.println("rabbit is resting...");
                Thread.sleep(2);
            }
        }
    }

    private boolean gameOver(int step) {
        if (winner != null) {   //已经存在胜利者，就结束
            return true;
        }
        if (step == 100) {
            winner = Thread.currentThread().getName();
            System.out.println("Winner is " + Thread.currentThread().getName());
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //1、创建一条赛道
        Race race = new Race();
        //2、创建龟兔线程
        new Thread(race, "rabbit").start();
        new Thread(race, "turtle").start();
    }
}
