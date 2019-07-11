package telran_20190711;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CodeTest {

    // @TestNG or @JUnit for testing
    @Test
    public void testGetLength() {

        String testInput = "Hello JUnit"; // входные данные
        int length = CodeForTest.getLength(testInput); // вызов метода которыйй проверяем

        assertEquals(22, length); // проверка результата
    }

    @Test(expected = NullPointerException.class)
    public void testGetLengthNull() {

        String testInput = null; // входные данные
        int length = CodeForTest.getLength(testInput); // вызов метода которыйй проверяем


    }

    @Test
    public void testGetLengthSpaces() {

        String testInput = "       "; // входные данные
        int length = CodeForTest.getLength(testInput); // вызов метода которыйй проверяем

        assertEquals(14, length); // проверка результата
    }

    @Test
    public void testGetLengthPoint() {

        String testInput = ""; // входные данные
        int length = CodeForTest.getLength(testInput); // вызов метода которыйй проверяем

        assertEquals(0, length); // проверка результата
    }
}
