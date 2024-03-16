package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;



public class Task1 {

    public static void execute(Object obj) throws Exception {
        Class<?> clazz;

        if (obj instanceof String str) {
            clazz = Class.forName(str);
        } else if (obj instanceof Class<?> aClazz) {
            clazz = aClazz;
        } else {
            throw new IllegalArgumentException("Class " + obj + " not exists!");
        }

        StringBuilder sb = new StringBuilder();

        // Add package name
        Package pkg = clazz.getPackage();
        if (pkg != null) {
            sb.append("package ").append(pkg.getName()).append(";\n\n");
        }

        // Add class modifiers and name
        int modifiers = clazz.getModifiers();
        sb.append(Modifier.toString(modifiers)).append(" class ").append(clazz.getSimpleName());

        // Add superclass
        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null) {
            sb.append(" extends ").append(superclass.getSimpleName());
        }

        // Add implemented interfaces
        Class<?>[] interfaces = clazz.getInterfaces();
        if (interfaces.length > 0) {
            sb.append(" implements ");
            for (int i = 0; i < interfaces.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(interfaces[i].getSimpleName());
            }
        }

        sb.append(" {\n");

        // Add fields
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            sb.append("\t").append(Modifier.toString(field.getModifiers())).append(" ");
            sb.append(field.getType().getSimpleName()).append(" ");
            sb.append(field.getName()).append(";\n");
        }

        // Add constructors
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            sb.append("\n\t").append(Modifier.toString(constructor.getModifiers())).append(" ");
            sb.append(clazz.getSimpleName()).append("(");
            Class<?>[] paramTypes = constructor.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(paramTypes[i].getSimpleName()).append(" arg").append(i);
            }
            sb.append(") {}\n");
        }

        // Add methods
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            sb.append("\n\t").append(Modifier.toString(method.getModifiers())).append(" ");
            sb.append(method.getReturnType().getSimpleName()).append(" ");
            sb.append(method.getName()).append("(");
            Class<?>[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(paramTypes[i].getSimpleName()).append(" arg").append(i);
            }
            sb.append(") {}\n");
        }

        System.out.println(sb);
    }
}
