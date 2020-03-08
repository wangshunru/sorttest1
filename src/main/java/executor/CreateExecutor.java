package executor;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by wangshunxi on 2019/11/25.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */
public class CreateExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个类对象
        Runnable oneRunnable = new SomeRunnable();
        //由runnable创建一个Thread对象
        Thread oneThread = new Thread(oneRunnable);
        //启动线程 当执行start()时，就会执行Runnable对象中的run()
        oneThread.start();

        Callable<Integer> oneCall = new SomeCallable();
        //由callable 对象创建一个FutureTask对象
        FutureTask<Integer> futureTask = new FutureTask<Integer>(oneCall);
        //futuretask是一个包装器，他通过接受callablel创建，他同时实现了Future和Runnable
        Thread thread = new Thread(futureTask);
        thread.start();
        Integer integer = futureTask.get();
    }
}

class SomeRunnable implements Runnable {

    public void run() {
        System.out.println("实现Runnable接口");
    }
}

//通过Callable接口创建
class SomeCallable implements Callable<Integer>{

    public Integer call() throws Exception {
        return new Random().nextInt();
    }
}

