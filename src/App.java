import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        int i = 0;
        
        while (i++ < 3) {
            executorService.execute(new MyThread(1));
            executorService.execute(new MyThread(4));
            executorService.execute(new MyThread(5));
            executorService.execute(new MyThread(2));
            executorService.execute(new MyThread(3));
        }

        executorService.shutdown();
    }
}

class MyThread implements Runnable {

    private int value;

    MyThread(int val) {
        this.value = val;
    }

    @Override
    public void run() {
        try {
            Thread t = Thread.currentThread();
            Thread.sleep(2000);
            System.out.println("Processing for digit " + this.value + " with the thread : " + t.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}