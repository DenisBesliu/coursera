package shuffle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import help.Messages;
import help.NullArrayException;

/**
 * @author dbesliu
 * @created 4/1/13
 */
public class ScuffleTest {

    Shuffle<String> shuffleString;


    @Before
    public void setUp() throws Exception {
        shuffleString = new Shuffle<String>();

    }


    @Test(expected = NullArrayException.class)
    public void nullArray() {
        shuffleString.shuffle(null);
    }


    @Test
    public void emptyArray() {
        final String[] shuffledArray = shuffleString.shuffle(new String[] {});
        final int length = shuffledArray.length;
        assertEquals(String.format(Messages.ARRAY_NOT_EMPTY_MESSAGE.toString(), length), 0, length);
    }


    @Test
    public void stringArray() {
        final String[] actualResult = shuffleString.shuffle(getSortedArray());
        final int expectedLength = getSortedArrayLength();
        final int actualLength = actualResult.length;
        final String message = String.format(Messages.ARRAYS_LENGTH_NOT_EQUALS_MESSAGE.toString(), expectedLength, actualLength);
        assertEquals(message, expectedLength, actualLength);
        assertTrue(Messages.ARRAY_NOT_SHUFFLED_MESSAGE.toString(), isArrayShuffled(actualResult));
    }


    private boolean isArrayShuffled(final String[] aActualResult) {
        boolean result = false;
        final String[] sortedArray = getSortedArray();
        for (int i = 0; i < aActualResult.length; i++) {
            if (!aActualResult[i].equals(sortedArray[i])) {
                result = true;
                break;
            }
        }
        return result;
    }


    private int getSortedArrayLength() {
        return getSortedArray().length;
    }


    private String[] getSortedArray() {
        return new String[] { "a", "b", "c", "d", "e", "f", "g" };
    }
}
