import java.util.concurrent.atomic.LongAdder;

public class Main {
    static long total = 0;

    public static void main(String[] args) throws InterruptedException {
        LongAdder adder = new LongAdder();
        Store store1 = new Store(adder);
        Store store2 = new Store(adder);
        Store store3 = new Store(adder);

        Thread t1 = new Thread(store1, "store1");
        Thread t2 = new Thread(store2, "store2");
        Thread t3 = new Thread(store3, "store3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(total);
    }
}
