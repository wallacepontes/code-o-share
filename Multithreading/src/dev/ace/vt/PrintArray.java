package dev.ace.vt;

public class PrintArray implements Runnable {
    private final String[] arrayToPrint;

    public PrintArray(String[] arrayToPrint) {
        this.arrayToPrint = arrayToPrint;
    }

    @Override
    public void run() {
        for (String element : arrayToPrint) {
            System.out.println(element);
        }
    }
}
