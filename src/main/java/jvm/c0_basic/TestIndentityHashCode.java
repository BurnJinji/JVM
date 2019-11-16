package jvm.c0_basic;

public class TestIndentityHashCode {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.hashCode());
        System.out.println(System.identityHashCode(o));

        System.out.println("-----------------------------------");

        T t = new T();
        System.out.println(t.hashCode());
        System.out.println(t.superClass());
        System.out.println(System.identityHashCode(t));

        System.out.println("-----------------------------------");

        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println(System.identityHashCode(s1) == System.identityHashCode(s2));

    }

    private static class T {
        @Override
        public int hashCode() {
            return 1;
        }

        public int superClass() {
            return super.hashCode();
        }
    }

}
