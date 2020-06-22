//Creating a thread can be achieved by extending the Threads class and overriding run()...

public class AnotherThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(ThreadColour.THREAD_THREADS + "2. AnotherThread thread based on Threads class started (run" +
				" " +
				"dependent on" +
				" the OS)");

		// allow for a separate thread to interrupt this thread as AnotherThread sleeps
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			System.out.println(ThreadColour.THREAD_THREADS + "2. Another thread woke me up!");
			return;
		}
		
		System.out.println(ThreadColour.THREAD_THREADS + "2. AnotherThread thread finished");
	}
}
