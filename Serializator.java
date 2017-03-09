package by.epam.tr.lesson13;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializator {
	public static void serialize(MyObject myComplexObject, String fileName) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			objectOutputStream.writeObject(myComplexObject);
		};
	}
}
