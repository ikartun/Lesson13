package by.epam.tr.lesson13;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class MyObjectExtCustomSerializable extends MyObject implements Serializable {
	private static final long serialVersionUID = -3366392704405807041L;
	private int number;
	private MyTime myTime;
	private transient Thread thread;

	public MyObjectExtCustomSerializable(String name, int number) {
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
					System.out.println("My object works...");
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
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		in.defaultReadObject();
		startThread();
	}

	@Override
	public String toString() {
		return "MyComplexObjectExtension [number=" + number + ", myTime=" + myTime.getDate() + ", thread=" + thread + "]";
	}

}
