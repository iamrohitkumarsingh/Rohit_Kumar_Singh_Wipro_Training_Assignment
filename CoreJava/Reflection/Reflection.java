package com.wipro.assign;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ExampleClass {
    private String privateField = "Initial Value";

    public ExampleClass() {}

    public void publicMethod() {
        System.out.println("Public Method Called");
    }

    private void privateMethod() {
        System.out.println("Private Method Called");
    }
}

public class Reflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            ExampleClass example = new ExampleClass();

            Class<?> clazz = example.getClass();

            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("Methods:");
            for (Method method : methods) {
                System.out.println(" - " + method.getName());
            }

            Field[] fields = clazz.getDeclaredFields();
            System.out.println("\nFields:");
            for (Field field : fields) {
                System.out.println(" - " + field.getName());
            }
            
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println(" - " + constructor.getName());
            }

            Field privateField = clazz.getDeclaredField("privateField");
            privateField.setAccessible(true); // Make the private field accessible
            privateField.set(example, "Modified Value"); // Set the new value

            System.out.println("\nModified private field value: " + privateField.get(example));

        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
