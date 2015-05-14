package run;

public class SeriesRunExample extends Thread {
    private static int currentMax = 1;
    private int mainId;
    private final Object waitObject;

    public SeriesRunExample(int id, Object waitObject) {
        this.mainId = id;
        this.waitObject = waitObject;
    }

    public static void example() {
        Object waitObject = new Object();
        for (int i = currentMax; i <= 10; ++i) {
            Thread thread = new SeriesRunExample(i, waitObject);
            thread.start();
        }
    }

    public void run() {
        try {
            System.out.println("Start run of thread: " + mainId);
            synchronized (waitObject) {
                while (mainId > currentMax) {
                    waitObject.wait();
                }

                currentMax++;
                System.out.println("Hello from thread: " + mainId);
                waitObject.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
