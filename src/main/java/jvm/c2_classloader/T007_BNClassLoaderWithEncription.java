package jvm.c2_classloader;

import jvm.Hello;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class T007_BNClassLoaderWithEncription extends ClassLoader {
    public static int seed = 0B10110011;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("c:/test/", name.replace('.', '/').concat(".msbclass"));

        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;

            while ((b = fis.read()) != 0) {
                baos.write(b ^ seed);
            }

            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();

            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return super.findClass(name);
        }
    }

    public static void main(String[] args) throws Exception {
        encFile("jvm.Hello");

        ClassLoader loader = new T007_BNClassLoaderWithEncription();
        Class<?> clazz = loader.loadClass("jvm.Hello");
        Hello h = (Hello) clazz.newInstance();
        h.m();

        System.out.println(loader.getClass().getClassLoader());
        System.out.println(loader.getParent());
    }

    private static void encFile(String name) throws Exception {
        File f = new File("c:/test/", name.replace('.', '/').concat(".class"));

        FileInputStream fis = new FileInputStream(f);
        FileOutputStream fos = new FileOutputStream(new File("c:/test/", name.replace('.', '/').concat(".msbclass")));
        int b = 0;

        while ((b = fis.read()) != -1) {
            fos.write(b ^ seed);
        }

        fis.close();
        fos.close();
    }
}
