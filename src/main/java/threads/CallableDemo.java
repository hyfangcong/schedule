package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {
    private static Callable<String> callable = new Callable<String>() {
        @Override
        public String call() throws Exception {
            Thread.sleep(2000);

            return "call";
        }
    };

    ExecutorService executor = Executors.newFixedThreadPool(10);
    List<Future<String>> res = new ArrayList<>();

    CompletionService service = new ExecutorCompletionService(Executors.newFixedThreadPool(10));

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo demo = new CallableDemo();
//        demo.callTest();
//        for(int i=0; i<10; i++){
//            System.out.println(demo.res.get(i).get());
//        }
        demo.completionServiceTest();
        for(int i=0; i<10; i++){
            System.out.println(demo.service.take().get());
        }
    }

    public void callTest(){
        for(int i=0; i<10; i++){
            res.add(executor.submit(callable));
        }
    }

    public void completionServiceTest(){
        for(int i=0; i<10; i++){
            service.submit(callable);
        }
    }
}
