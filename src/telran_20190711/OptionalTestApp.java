package telran_20190711;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class OptionalTestApp {
    public static void main(String[] args) {
        Optional<String> ivan = Optional.of("Ivan");

        System.out.println("******* 1 ***********");
        if(ivan.isPresent()) System.out.println(ivan.get().length());
        System.out.println("******* 2 ***********");
        ivan.ifPresent(s -> System.out.println(s.length()));
        System.out.println("******* 3 ***********");
        Consumer<String> consumer = s -> System.out.println(s.length());
        ivan.ifPresent(consumer);

        List<Integer> list = Arrays.asList(1,2,3,4,8);

        System.out.println(getMoreThan(list, 4));

        Integer number = getMoreThan(list, 4);

        System.out.println(number.toString());

        // Optional as container for exception solution

        Optional<Integer> moreThan = getMore(list, 4);
        //System.out.println(moreThan.get().toString());

        System.out.println(moreThan.map(i -> i * 4).orElse(-1));

        Optional<String> stringEmpty = Optional.empty();

        System.out.println(stringEmpty.orElse("******"));

        Optional<String> stringEmptyName = Optional.of("MyName");

        System.out.println(stringEmpty.orElse("String is empty"));
    }

    public static Integer getMoreThan(List<Integer> list, int a) {
        for(Integer i : list) {
            if(i>a) return i;
        }
        return null;
    }

    public static Optional<Integer> getMore(List<Integer> list, int a) {
        for(Integer i : list) {
            if(i>a) return Optional.of(i);
        }
        return Optional.empty();
    }

    public static Optional<Integer> getMoreThan2(List<Integer> list, int a) {
        Optional<Integer> first = list.stream()
                                        .filter(i -> i > a)
                                        .findFirst();

        // findFirst пример терминальной функции - функция которая возвращает значение
        return first;
    }
}
