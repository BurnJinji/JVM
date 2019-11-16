package jvm.c0_basic;

public class TestPlusPlus {
    public static void main(String[] args) {
        int i = 8;
        i = ++i;
    }

    void m() {
        new Runnable() {
            @Override
            public void run() {
                new Object();
            }
        };
    }

}
