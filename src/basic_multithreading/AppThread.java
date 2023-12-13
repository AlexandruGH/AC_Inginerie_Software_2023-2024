package basic_multithreading;

public class AppThread {
    static class Runner extends Thread{

        @Override
        public void run(){
            for (int i=0; i < 10; i++){
                System.out.println("Hello: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args){
        Runner runnerOne = new Runner();
        runnerOne.start();

        Runner runnerTwo = new Runner();
        runnerTwo.start();
    }
}
