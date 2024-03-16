package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class Task2 {

    public static void execute(Object obj) {
        System.out.println("Тип об'єкту: " + obj.getClass().getName());

        System.out.println("Стан об'єкту:");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.getType() == byte[].class && field.getName().equals("value") && !Modifier.isFinal(field.getModifiers())) {
                    System.out.println(field.getName() + " = НЕДОСТУПНО (небезпечна операція)");
                } else {
                    System.out.println(field.getName() + " = " + field.get(obj));
                }
            } catch (IllegalAccessException e) {
                System.out.println(field.getName() + " = НЕДОСТУПНО");
            }
        }

        System.out.println("Відкриті методи:");
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.println(method.getName());
            }
        }
    }
}
