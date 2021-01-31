package Semafory;

import java.util.concurrent.Semaphore;

public class Silnia extends Thread {
    private Semaphore semaphore;
    private int val;

    public Silnia(Semaphore semaphore, int val) {
        this.semaphore = semaphore;
        this.val = val;
    }

    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Calculating factorial of " + val + "...");
            sleep(5000);
            System.out.println("Factorial of " + val + " is: " + calculate(val));
        } catch(InterruptedException ignored) {
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            semaphore.release();
            System.out.println("Calculating factorial of " + val + " has been finished");
        }
    }

    private int calculate(int val) {
        if (val < 0) {
            throw new IllegalArgumentException("Val must be greater or equal than 0.");
        }

        if (val <= 1) {
            return 1;
        }

        return val * calculate(val - 1);
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        Silnia silnia1 = new Silnia(semaphore, 4);
        Silnia silnia2 = new Silnia(semaphore, 5);
        Silnia silnia3 = new Silnia(semaphore, 6);
        Silnia silnia4 = new Silnia(semaphore, 7);
        Silnia silnia5 = new Silnia(semaphore, 1);
        Silnia silnia6 = new Silnia(semaphore, -1);
        silnia1.start();
        silnia2.start();
        silnia3.start();
        silnia4.start();
        silnia5.start();
        silnia6.start();
    }

}

