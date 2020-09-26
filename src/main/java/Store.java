import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Store implements Runnable {
    LongAdder adder;
    private Random random = new Random();
    private int[] arr;

    public Store(LongAdder adder) {
        this.adder = adder;
        initialize();
    }

    private void initialize() {
        int size = random.nextInt((50) + 50);
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(999) + 1;
        }
    }

    public int[] getArr() {
        return arr;
    }


    @Override
    public void run() {
        Arrays.stream(getArr()).forEach(adder::add);
        long sum = adder.sum();
        Main.total += sum;
        System.out.println(Thread.currentThread().getName() + " Result: " + adder.sum());
    }
}
