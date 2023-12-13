package basic_multithreading;

public class AppInterfaceThread {
    public static void main(String[] args){
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Hello: " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadOne.start();
    }
}
