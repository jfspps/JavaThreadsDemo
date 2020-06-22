//...or by implementing Runnable interface and overriding run()

public class MyRunnable implements Runnable{

	//Runnable is an interface, of which the objects are run by a thread, so one needs to define run()
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(ThreadColour.THREAD_RUNNABLE + "Runnable thread.");
	}

	
}
