package dev.multithreading;

public class PrintStringArray implements Runnable {
    private final String[] arrayToPrint;

    public PrintStringArray(String[] arrayToPrint) {
        this.arrayToPrint = arrayToPrint;
    }

    @Override
    public void run() {
        for (String element : arrayToPrint) {
            System.out.println(element);
        }
    }
}
