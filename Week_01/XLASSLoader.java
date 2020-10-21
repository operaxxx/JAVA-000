package hk.week1;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class XLASSLoader extends ClassLoader{
    public static void main(String[] args) {
        Class hello = null;
        try {
            hello = new XLASSLoader().findClass("Hello");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object obj = null;
        try {
            obj = hello.getConstructor().newInstance();
            hello.getMethod("hello").invoke(obj);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            InputStream inputStream = XLASSLoader.class.getClassLoader().getResourceAsStream("Hello.xlass");
            System.out.println(inputStream);

            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte)(255 - bytes[i]);
            }

            return defineClass(name, bytes, 0, bytes.length);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
