package telran_20190618;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimDemo {

    static Integer test;

    public static void main(String[] args) {
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);

        System.out.println(i1==i2);

        Integer i3 = 15;
        Integer i4 = 15;

        System.out.println(i3==i4);

        /* optimisation java machine jvm */
        Integer i5 = 1255;
        Integer i6 = 1255;

        System.out.println(i5==i6);

        List<Integer> l1 = Arrays.asList(1,5,7,-127,127,128);
        List<Integer> l2 = Arrays.asList(1,5,7,-127,127,128);

        System.out.println(compareList(l1,l2));


        // wrupper unwrapper
        Integer t1 = 10;
        Integer t2 = 10;

        System.out.println(new TestComparator().compare(t1,t2));
        System.out.println(new TestComparator().compare(i5,i6));

        System.out.println("++++++++++++++");

        // very slow code
        Long counter = 1L;
        System.out.println("Counter: " + counter);

        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            //counter++;
        }

        System.out.println("++++++++++++++");

        // init error
       /* if(test == 42 ) {
            System.out.println("Unbelievable! ");
        }*/

        System.out.println("++++++ DEMO Functional Interface ++++++++");

        /* DEMO Functional Interface */
        Printable print = new Printable() {
            @Override
            public void print(String s) {
                System.out.println("Print1: " + s);
            }
        };
        print.print("Montag");


        // Type inference
        Printable print2 = s -> System.out.println("Print2: " + s);

        print2.print("Diensag");

        System.out.println("++++++ DEMO Countable Interface ++++++++");
        CountableTestInterface countable = (a,b) -> a+b;
        System.out.println(countable.count(5,6));
    }

    public static List<String> compareList(List<Integer> i1, List<Integer> i2) {
        List<String> l1 = new ArrayList<>();

        for(int i=0;i<i1.size();i++) {
            // if(i1.get(i).equals(i2.get(i))) {
            if(i1.get(i) == i2.get(i)) {
                l1.add("YES");
            } else {
                l1.add("NO");
            }
        }
        return l1;
    }
}
