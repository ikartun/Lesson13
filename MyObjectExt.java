package by.epam.tr.lesson13;

import java.io.Serializable;
import java.util.Date;

public class MyObjectExt extends MyObject implements Serializable {
	private static final long serialVersionUID = -3384073121737909357L;
	private int number;
	private MyTime myTime;
	private transient Thread thread;

	public MyObjectExt(String name, int number) {
		super(name);
		this.number = number;
		myTime = new MyTime(new Date());
		startThread();
	}
	
	private void startThread() {
		thread = new Thread() {
			@Override
			public void run() {
				while(!isInterrupted()) {
					System.out.println("My complex object works...");
				}
			}			
		};
		thread.start();
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

	@Override
	public String toString() {
		return "MyComplexObjectExtension [number=" + number + ", myTime=" + myTime.getDate() + ", thread=" + thread + "]";
	}

}
