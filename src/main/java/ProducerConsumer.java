import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by wangshunxi on 2019/11/21.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */
public class ProducerConsumer {
    //wait()和notify()是基于Object的两个方法，可以为任何对象实现同步机制
    //wait（）当缓冲区已满/空时，生产者/消费者线程停止自己的执行，放弃锁，是自己处于等待状态，让其他线程执行
    //notify()当生产者/消费者向缓冲区放入/取出一个产品时，向其他等待的线程发出可执行的通知，同时放弃锁，是自己处于等待状态
    private static final int CAPACITY = 5;

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Thread producer1 = new Producer("p1", queue, CAPACITY);
        Thread producer2 = new Producer("p1", queue, CAPACITY);
        Thread consumer1 = new Consumer("p1", queue, CAPACITY);
        Thread consumer2 = new Consumer("p1", queue, CAPACITY);
        Thread consumer3 = new Consumer("p1", queue, CAPACITY);
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }

    /*
    * 生产者
    * */
    public static class Producer extends Thread {
        private Queue<Integer> queue;
        String name;
        int maxSize;
        int i = 0;

        public Producer(String name, Queue<Integer> queue, int maxSize) {
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == maxSize) {
                        try {
                            System.out.println("queue is full");
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(name + "\t" + i);
                    queue.offer(i++);
                    queue.notify();

                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /*
    * 消费者
    * */
    public static class Consumer extends Thread {
        private Queue<Integer> queue;
        String name;
        int maxSize;

        public Consumer(String name, Queue<Integer> queue, int maxSize) {
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            System.out.println("isEmpty");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int x = queue.poll();
                    System.out.println(name + "\t" + x);
                    queue.notify();
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
