package telran_20190618;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class StringCompareDemo {
    public static void main(String[] args) {
        String[] strings = {"a","bbb","cccc","fff","f"};

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };


        Comparator<String> compare = (s1,s2) -> Integer.compare(s1.length(),s2.length());

        Arrays.sort(strings);
        for(String s : strings) System.out.println(s);

        System.out.println("==================");
        Arrays.sort(strings,compare);

        for (String s: strings) System.out.println(s);

        System.out.println("======== 1 ==========");
        StringConcate sc = (a, b) -> Integer.toString(a)+Integer.toString(b);
        System.out.println(sc.concat(12,34));


        BiFunction<Integer,Integer,String> bifunc = (a,b) -> Integer.toString(a)+Integer.toString(b);

        System.out.println("========= 2 =========");
        Checkable check = a -> a.length() == 3 ? true : false;
        System.out.println(check.check("ssdfsdf"));
        System.out.println(check.check("ssd"));

        System.out.println("========= 3 =========");
        Checkable checkMod = a -> a.length()%2 == 0 ? true : false;
        System.out.println(checkMod.check("dfvcdfgdfgdfg"));
        System.out.println(checkMod.check("hgtzui"));

        System.out.println("========= 4 =========");
        Transformable tr = a -> a.toUpperCase();
        System.out.println(tr.modify("dfdfgdfgdfg"));

        System.out.println("========= 5 =========");
        Transformable transform = a -> a.length() == 4 ? "****" : a;
        System.out.println(transform.modify("QWErwewTY"));
        System.out.println(transform.modify("QWER"));

        System.out.println("========= 6 =========");
        Printa pr = a -> System.out.println("!" + a + "!");

        System.out.println("========= 7 =========");
        Producable prod = () -> "Hello Word";
        System.out.println(prod.produce());

        int[] a = {1,3,5,6,7,8};
        System.out.println(sumAllEven(a));

    }

    public static int sumAll(int[] input) {
        int res = 0;
        for (int a:input) res +=a;
        return res;
    }

    public static int sumAllEven(int[] input) {
        int res = 0;
        for (int a:input) res = res + (a%2 == 0 ? a : 0);
        return res;
    }
}
