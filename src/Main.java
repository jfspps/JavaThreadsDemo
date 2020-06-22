
public class Main {

    public static void main(String[] args) {
        // this runs on the main() thread
        System.out.println(ThreadColour.THREAD_MAIN + "1. Main method thread");

        // one cannot start threads two and three again after running start()

        // highlight the second thread, using Thread class
        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        // highlight the third thread, using Runnable interface
        new Thread(() -> System.out.println(ThreadColour.THREAD_ANON + "3. Anonymous class thread. Exponential: " + math_module.exponential(1, 100))).start();


        // implementing Runnable is often more convenient that extending Thread
        // sets up another new, fourth thread
        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ThreadColour.THREAD_RUNNABLE + "4. Another Main main()'s Runnable thread started");
                //join two threads (the thread which joins waits for the other to terminate before continuing)
                try {
                    //wait for up to 2000 ms for AnotherThread to finish...
                    anotherThread.join(5000);
                    //...then continue (regardless if anotherThread dies or not)
                    System.out.println(ThreadColour.THREAD_RUNNABLE + "AnotherThread finished, resuming with (4) " +
                            "myRunnableThread");
                } catch (InterruptedException e) {
                    System.out.println(ThreadColour.THREAD_RUNNABLE + "myRunnableThread interrupted, could not execute after" +
                            " anotherThread");
                }
            }
        });
        myRunnableThread.start();

        // one can interrupt the second thread
//		anotherThread.interrupt();

        // the following is run on main() thread again
        System.out.println(ThreadColour.THREAD_MAIN + "5. Main method thread again. Did this message appear before or" +
                " after the (2) anotherThread run()?");

        System.out.println();
    }

}

class math_module {

    // calls exp(x), with n the number of terms in the Taylor's Series
    static public double exponential(double x, int n) {
        double s = 1.0d;

        //cycle through n terms (this approach is using Horner's rule to reduce time complexity to O(n)
        for (int i = n; i > 0; i--) {
            s = 1 + (x/(double)i)*s;
        }
        return s;
    }
}
