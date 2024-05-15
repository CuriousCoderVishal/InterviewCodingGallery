public class Example {
    public static void main(String[] args) {
       /* Runnable runnable  = new Runnable() {
            @Override
            public void run() {
                System.out.println("My thread");
            }
        };

        Thread thread  = new Thread(runnable);
        thread.start();
*/
        Mythread  mythread = new Mythread();
        mythread.start();

    }
}
class Mythread extends Thread{
    @Override
    public void run() {
        System.out.println("Hi");
    }
}