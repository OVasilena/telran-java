package telran_20190627;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApp {

    public static void main(String[] args) {
        Address a1 = new Address("mira", 115);

        Person p1 = new Person("Ivan", 15,a1);
        Person p2 = new Person("Maria", 25,a1);
        Person p3 = new Person("Petr", 55,a1);

        List<Person> personList = Arrays.asList(p1,p2,p3);

        // группировка по возрасту
        List<Address> collectPerson = personList
                .stream()
                .filter(p -> p.age > 17)
                .map(Person::getAddress)
                .collect(Collectors.toList());

        System.out.println(collectPerson);


        // 2.
        Stream<String> name = Stream.of("Ivan", "Petr", "Petr", "Ivan", "Maria");
        Set<String> collect1 = name.collect(Collectors.toSet());
        System.out.println(collect1);


        Stream<String> name2 = Stream.of("Ivan", "Petr", "Petr", "Ivan", "Maria");
        List<String> collect2 = name2.collect(Collectors.toList());
        System.out.println(collect2);



        // 4 -> 3, 3-> 1, 5 -> 2
        Stream<String> name3 = Stream.of("Ivan",
                "Masha",
                "Lena",
                "Misha",
                "Vova",
                "Ket");

        // groupingBy - gruppiert stream in map, String::length ist key
        Map<Integer, List<String>> listMap = name3.collect(Collectors.groupingBy(String::length));

        listMap.forEach((k,v) -> System.out.println(k + " ->" + v));

        // переложить список в мапу
        Map<Integer, String> collect3 = personList.stream().collect(Collectors.toMap(k->k.age, v->v.name));

        // k->k.age, v->v.name  ist identisch wie Person::age, Person::name (bzw. mit Methoden getAge, getName)

        // 4. analog списка

        System.out.println("******* BANK ************");
        // 5. со списка вернуть список BankAccount
        BankAccount b1 = new BankAccount("DE122345566", p1);
        BankAccount b2 = new BankAccount("DE455665435", p2);
        BankAccount b3 = new BankAccount("DE45632ee24", p3);
        BankAccount b4 = new BankAccount("DE498765155", p1);

        Stream<BankAccount> banks = Stream.of(b1,b2,b3,b4);

        List<BankAccount> collect4 = banks.map(b-> new BankAccount(alianate(b.getIban()), b.getOwner())).collect(Collectors.toList());
        System.out.println(collect4);

        // 6

        // 8 + 9

        // посчитать возраст всех персон и записать в класс Box
        // написать свой коллектор


        System.out.println("###### sum Age ########");

        System.out.println("Summe: " + sumAge(personList));



    }

    public static String alianate(String input) {
        String myInput=input.substring(0,3);
        for (int i = 3; i<input.length(); i++) {
            myInput += "*";
        }
        return myInput;
    }


    public static int sumAge(List<Person> persons) {

        return persons
                .stream()
                .filter(p -> p.age > 17)
                .reduce(0, (a, b) -> a + b.getAge(), (a, b) -> a + b);

    }

}
