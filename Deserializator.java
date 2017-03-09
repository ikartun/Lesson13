package by.epam.tr.lesson13;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializator {
	public static MyObject deserialize(String fileName) throws ClassNotFoundException, IOException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		MyObject myComplexObject = null;
		
		try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
			myComplexObject = (MyObject) objectInputStream.readObject();
		};
		
		return myComplexObject;
	}
}
