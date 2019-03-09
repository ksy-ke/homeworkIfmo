package shatokhina;


import com.shatokhina.homework1.task1.Parallelepiped;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParallelepipedTest {

    @Test
    public void testPositiveNumbers() {
        // given
        int height = 20;
        int length = 40;
        int width = 35;

        // when
        Parallelepiped parallelepiped = new Parallelepiped(height, length, width);

        // then
        assertEquals(5800, parallelepiped.area());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumbers() {
        // given
        int height = -20;
        int length = 40;
        int width = 35;

        // when
            Parallelepiped parallelepiped = new Parallelepiped(height, length, width);

        // then
        // Exception thrown
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithZero() {
        // given
        int height = 20;
        int length = 0;
        int width = 35;

        // when
        Parallelepiped parallelepiped = new Parallelepiped(height, length, width);

        // then
        // Exception thrown
    }
}