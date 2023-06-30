package ex00;


class MyRunnable implements Runnable {
    private final String _name;
    private final  int _count;

    MyRunnable(String name, int count) {
        this._name = name;
        this._count = count;
    }

    public void run() {
        for (int i = 0; i < _count; i++) {
            System.out.println(_name);
        }
    }
}

public class Program {

    public static void main(String[] args) {
        int count = 50;
        MyRunnable Egg = new MyRunnable("Egg", count);
        MyRunnable Hen = new MyRunnable("Hen", count);

        // Create and start the thread
        Thread eggThread = new Thread(Egg);
        Thread henThread = new Thread(Hen);
        eggThread.start();
        henThread.start();

    }
}
