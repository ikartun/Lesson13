package by.epam.tr.lesson13;

import java.io.IOException;
import java.util.Date;

public class Executor {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		String fileName = "d:/serialize.txt";
		MyObject restoredMyComplexObject = null;
		
		//Standard serialization
		System.out.println("Standard serialization");
		
		MyObject myComplexObject = new MyObjectExt("myObjectExt", 1);
		
		System.out.print("My object before serialization: ");
		System.out.println(myComplexObject);
		
		Serializator.serialize(myComplexObject, fileName);		
		Thread.sleep(1000);
		restoredMyComplexObject = Deserializator.deserialize(fileName);
		
		System.out.println("Current date: " + new Date());
		System.out.print("My object after deserialization: ");
		System.out.println(restoredMyComplexObject);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");		
		
		
		//Custom serialization
		System.out.println("Custom serialization");
		
		myComplexObject = new MyObjectExtCustomSerializable("myObjectExt", 1);
		restoredMyComplexObject = null;
		
		System.out.print("My object before serialization: ");
		System.out.println(myComplexObject);
		
		Serializator.serialize(myComplexObject, fileName);		
		Thread.sleep(1000);
		restoredMyComplexObject = Deserializator.deserialize(fileName);
		
		System.out.println("Current date: " + new Date());
		System.out.print("My object after deserialization: ");
		System.out.println(restoredMyComplexObject);
	}
}
