package jvm;

import java.util.LinkedList;

/**
 * test heap out of memory
 *
 * Options: -verbose:gc -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    public static void main(String[] args) {
        LinkedList<Object> objects = new LinkedList<>();
        for (; ; ) {
            objects.add(new Object());
        }
    }
}
