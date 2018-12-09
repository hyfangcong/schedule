package threads;

import java.util.List;
import java.util.concurrent.*;

public class ThreadDemo {

    public static Runnable runnable = new Runnable() {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().hashCode());
        }
    };

    ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

    ExecutorService cacheThreadPool = Executors.newCachedThreadPool((r) -> {
        Thread thread = new Thread(r);
        thread.setName(getClass().getSimpleName()+"thread");
        thread.setDaemon(true);
        return thread;
    });

    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

    ScheduledExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(10);

    public void cacheTreadPoolTest(){
        for(int i=0; i<10; i++){
            cacheThreadPool.execute(runnable);
        }
    }

    public void singleThreadPoolTest(){
        for(int i=0; i<10; i++){
            singleThreadPool.execute(runnable);
        }
    }

    public void fixedThreadPoolTest(){
        for(int i=0; i<10; i++){
            fixedThreadPool.execute(runnable);
        }
    }

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
//        demo.cacheTreadPoolTest();
//        demo.singleThreadPoolTest();
//        demo.fixedThreadPoolTest();
        demo.scheduleThreadPool.scheduleAtFixedRate(runnable,20,3,TimeUnit.SECONDS);
        demo.scheduleThreadPool.scheduleWithFixedDelay(runnable,0,10,TimeUnit.SECONDS);
        demo.fixedThreadPool.submit(runnable);
//        List<Object> result = demo.fixedThreadPool
    }
}
