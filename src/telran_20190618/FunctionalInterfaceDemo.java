package telran_20190618;

// иерархия наследования таким образом более гибкая
public class FunctionalInterfaceDemo implements Countable{

    @Override
    public int coint(int i) {
        return value() + i;
    }


    // функциональное программирование без переменных используя рекурсивность и является statelos
    // не происходит изменения состояния в реализующем класее
    // есть входящие данные и выходящие

}
