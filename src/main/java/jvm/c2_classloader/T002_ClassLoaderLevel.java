package jvm.c2_classloader;

import sun.awt.HKSCS;

public class T002_ClassLoaderLevel {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(HKSCS.class.getClassLoader());
        System.out.println(T002_ClassLoaderLevel.class.getClassLoader());

        System.out.println(T002_ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
