package telran_20190618;

public interface Countable {

    int initValue = 10; // public static состояние класса
    int coint(int i);

    // sei Java8 добавилось поведение но не состояние объекта
    default int value() {
        return initValue;
    }
}
