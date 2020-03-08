package mianshi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by wangshunxi on 2019/11/25.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */
public class ProCon {
    private static final int CAPACITY = 5;

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Producer producer = new Producer("producer", 5, queue);
        producer.start();
        Consumer consumer1 = new Consumer("consumer1", queue, 5);
        consumer1.start();
        Consumer consumer2 = new Consumer("consumer2", queue, 5);
        consumer2.start();

    }

    public static class Producer extends Thread{
        private Queue<Integer> queue;
        String name;
        int maxSize;
        int i = 0;

        public Producer(String name,int maxSize,Queue<Integer> queue){
            super(name);
            this.name = name;
            this.maxSize = maxSize;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    if (queue.size() == maxSize){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int j = this.i++;
                    queue.offer(j);
                    System.out.println(j);
                    queue.notifyAll();
                    try {
                        Thread.sleep(new Random().nextInt(2));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class Consumer extends Thread{
        private Queue<Integer> queue;
        String name;
        int maxSize;

        public Consumer(String name,Queue<Integer> queue,int maxSize){
            super(name);
            this.name = name;
            this.maxSize=maxSize;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    if (queue.isEmpty()){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer poll = queue.poll();
                    System.out.println(""+Thread.currentThread().getName()+"poll:"+poll);
                    queue.notifyAll();
                    try {
                        Thread.sleep(new Random().nextInt(2));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
