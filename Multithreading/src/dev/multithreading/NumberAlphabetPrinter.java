package dev.multithreading;

/**
 * Write a Java program to create two threads, where one thread prints numbers from 1 to 10 
 * and the other thread prints the corresponding alphabet (i.e., A to J). 
 * Ensure that the numbers are printed before the alphabets.
 */
public class NumberAlphabetPrinter {

    private final Object lock = new Object();
    private boolean numberPrinted = false;

    public static void main(String[] args) {
        NumberAlphabetPrinter printer = new NumberAlphabetPrinter();

        Thread numberThread = new Thread(() -> printer.printNumbers());
        Thread alphabetThread = new Thread(() -> printer.printAlphabets());
        
        System.out.println("Printer 1" );
        numberThread.start();
        alphabetThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        //V2
        Thread numberThreadV2 = new Thread(printer.printNumbersV2());
        Thread alphabetThreadV2 = new Thread(printer.printAlphabetsV2());

        System.out.println("\n\rPrinter 2" );
        numberThreadV2.start();
        alphabetThreadV2.start();
    }

    public void printNumbers() {
        synchronized (lock) {
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + " ");
                numberPrinted = true;
                lock.notify(); // Notify the alphabet thread
                try {
                    if (i < 10) {
                        lock.wait(); // Wait for the alphabet thread to print
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Runnable printNumbersV2() {
        return () -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    System.out.print(i + " ");
                    numberPrinted = true;
                    lock.notify(); // Notify the alphabet thread
                    try {
                        if (i < 10) {
                            lock.wait(); // Wait for the alphabet thread to print
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
    public Runnable printAlphabetsV2() {
        return () -> {
            synchronized (lock) {
                for (char c = 'A'; c <= 'J'; c++) {
                    try {
                        while (!numberPrinted) {
                            lock.wait(); // Wait for the number thread to print
                        }
                        System.out.print(c + " ");
                        numberPrinted = false;
                        lock.notify(); // Notify the number thread
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
    public void printAlphabets() {
        synchronized (lock) {
            for (char c = 'A'; c <= 'J'; c++) {
                try {
                    while (!numberPrinted) {
                        lock.wait(); // Wait for the number thread to print
                    }
                    System.out.print(c + " ");
                    numberPrinted = false;
                    lock.notify(); // Notify the number thread
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
