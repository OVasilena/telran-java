package telran_20190618;

import java.util.Comparator;

public class TestComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer firstInt, Integer secondInt) {

        int first = firstInt;
        int second = secondInt;

        return first < second ? -1 : first == second ? 0 : 1;
    }
}
