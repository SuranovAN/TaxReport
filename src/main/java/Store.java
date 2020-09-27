import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Store implements Runnable {
    private LongAdder adder;
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

//    public void getSum(){
//        int sum = Arrays.stream(getArr()).sum();
//        System.out.println(sum);
//    }

    @Override
    public void run() {
        Arrays.stream(getArr()).forEach(adder::add);
    }
}
