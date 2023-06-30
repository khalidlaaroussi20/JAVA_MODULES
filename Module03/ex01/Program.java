package ex01;

class  AlternatePrinting {
    private  boolean shouldPrintEgg = true;

    public synchronized void printEgg() throws InterruptedException {
        while (!shouldPrintEgg)
            wait();
        System.out.println("Egg");
        shouldPrintEgg = false;
        notify();
    }

    public synchronized void printHenz() throws InterruptedException {
        while (shouldPrintEgg)
            wait();
        System.out.println("Henz");
        shouldPrintEgg = true;
        notify();
    }
}

public class Program {

    public static void main(String[] args) {
        int count = 50;
        AlternatePrinting alternatePrinting = new AlternatePrinting();


        Thread threadHenz = new Thread(() -> {
            try {
                int  i = 0;
                while (i < count) {
                    alternatePrinting.printHenz();
                    i++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadEgg = new Thread(() -> {
            try {
                int  i = 0;
                while (i < count) {
                    alternatePrinting.printEgg();
                    i++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadEgg.start();
        threadHenz.start();
    }
}
