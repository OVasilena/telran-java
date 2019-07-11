package telran_20190627;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class CustomCollectorDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Ivan", 15, null);
        Person p2 = new Person("Maria", 25, null);
        Person p3 = new Person("Kat", 27, null);
        Person p4 = new Person("Serg", 33, null);

        // supplier()
        // accumulator()
        // combiner()
        // finisher()

        // возвращает структуру по которой будет аккумулировать данные
        Supplier<Box> supp = () -> {
            System.out.println("supplying starting value");
            return new Box(0);
        };

        // описывает как добавлять в коробку новые значения
        BiConsumer<Box, Person> accumulator = (result, person) -> {
            System.out.println(result.getAmount() + " " + person);
            result.setAmount(result.getAmount() + person.getAge());
        };

        // описывает как сложить stream многопоточный, выполнение параллельно
        BinaryOperator<Box> combiner = (res1, res2) -> {
            System.out.println("combining result");
            res1.setAmount(res1.getAmount() + res2.getAmount());
            return res1;
        };

        Function<Box, Integer> finisher = b -> {
            return b.getAmount();
        };

        // свой коллектор выполнения
        Collector<Person, Box,Box> collector = Collector
                .of(supp,
                        accumulator,
                        combiner,
                        Collector.Characteristics.CONCURRENT);

        Box box = Stream.of(p1,p2,p3,p4)
                .parallel()
                .collect(collector);

        System.out.println("total age: " + box.getAmount());

        System.out.println("****************");
        Collector<Person, Box, Integer> collector1 = Collector
                .of(supp,
                        accumulator,
                        combiner,
                        Box::getAmount);

        Integer result = Stream.of(p1,p2,p3).parallel().collect(collector1);

        System.out.println("Result: " + result);


        Collector<Person, Box, Boolean> collector2 = Collector
                .of(supp,
                        accumulator,
                        combiner,
                        b->b.getAmount() > 30);


    }
}
