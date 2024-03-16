package org.example;

import org.example.exception.FunctionNotFoundException;

import java.lang.reflect.Method;




public class Task3 {

    public static void execute(Object obj, String methodName, Object... args) {
        try {
            Class<?>[] argTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argTypes[i] = args[i].getClass();
            }
            Method method = obj.getClass().getMethod(methodName, argTypes);
            System.out.println("METHOD EXISTS: " + method);
        } catch (Exception e) {
            throw new FunctionNotFoundException("Function not found!" + e.getMessage());
        }
    }
}
