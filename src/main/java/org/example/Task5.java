package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
    У цій програмі клас MyClass реалізує інтерфейс MyInterface.

    Для трасування та профілювання методу myMethod()
    створюється проксі-об'єкт MyProxy, який реалізує
    інтерфейс InvocationHandler. У методі invoke()
    проксі-об'єкт отримує інформацію про викликаний
    метод, визначає час початку та закінчення його
    виконання, а також виводить інформацію про час
    виконання методу на екран. Клас ProxyDemo
    демонструє використання проксі-об'єкта для виклику
    методу myMethod(). При запуску програми буде
    виведена на екран інформація про час виконання методу myMethod().
 */

public class Task5 {

    public static void execute() {
        MyClass obj = new MyClass();

        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class},
                new MyProxy(obj)
        );

        proxy.myMethod();
    }
}


class MyClass implements MyInterface {
    public void myMethod() {
        System.out.println("MyClass.myMethod() called");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyProxy implements InvocationHandler {
    private Object obj;

    public MyProxy(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(obj, args);
        long endTime = System.currentTimeMillis();

        System.out.println("Method " + method.getName() + " took " + (endTime - startTime) + " milliseconds to execute.");

        return result;
    }
}

interface MyInterface {
    void myMethod();
}
