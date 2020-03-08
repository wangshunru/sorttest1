import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by wangshunxi on 2019/11/21.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */
public class ProducerConsumer2 {

    private static final int CAPACITY = 5;

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Thread p1 = new Producer1("p1",queue,CAPACITY);
        Thread c1 = new Consumer1("c1",queue,CAPACITY);
        p1.start();
        c1.start();
    }

    public static class Producer1 extends Thread {
        private Queue<Integer> queue;
        String name;
        int maxSize;
        int i = 0;

        public Producer1(String name, Queue<Integer> queue, int maxSize) {
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    while (queue.size() == maxSize){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
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
    consumer
    * */
    public static class Consumer1 extends Thread{
        private Queue<Integer> queue;
        String name;
        int maxSize;
        public Consumer1(String name,Queue<Integer> queue,int maxSize){
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    while (queue.isEmpty()){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer poll = queue.poll();
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
