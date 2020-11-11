import java.util.concurrent.CountDownLatch;

public class CountDownLatchHomework implements Runnable {
    private int result;
    private final CountDownLatch latch;

    public CountDownLatchHomework(CountDownLatch countDownLatch) {
        this.latch = countDownLatch;
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatchHomework homework = new CountDownLatchHomework(countDownLatch);
        new Thread(homework).start();
        countDownLatch.await();
        System.out.println("异步计算结果为：" + homework.result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    @Override
    public void run() {
        this.result = BaseCode.sum();
        latch.countDown();
    }
}
