package Syn;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

/**
 * Rainbow
 * 线程不安全集合
 *
 * @DATE:2023/9/18 0018
 */
public class SynList {
    @SneakyThrows
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                //线程同时存储到了一个位置，造成线程不安全
                //线程同步块
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(200);   //如果不sleep，会导致线程可能锁不住
        System.out.println(list.size());
    }
}

