# Collectors, Stream API

List<String> myList = Arrays.asList("Sergey", "Piotr", "Ivan", "Sarah", "John");
myList    
  .stream()
  .filter(s -> s.startsWith("S"))    
  .map(String::toUpperCase)    
  .forEach(System.out::println);
  
## 
1.Есть два класса
public class Person {  String name;  int age;  Address address;}

public class Address {  String street;  int houseNumber;}

Нужно написать функцию, которая по списку persons вернет список адресов техлюдей, чей возраст больше 17 лет


destinct учитывает state потока .....!!!! прочитать

## Profiling
AOP Aspect Oriented Programming - что делать при вызове метода и что делать при завершении метода

DATE | DATETIME | TIMESTAMP?