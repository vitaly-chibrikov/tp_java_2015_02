package interference;

public final class InterferenceThread extends Thread {
    private final InterferenceExample checker;
    private static int i;

    public InterferenceThread(InterferenceExample checker) {
        this.checker = checker;
    }

    public void run() {
        while (!checker.stop()) {
            increment();
        }
    }

    public void increment() {
            i++;
    }

    public int getI() {
        return i;
    }
}
