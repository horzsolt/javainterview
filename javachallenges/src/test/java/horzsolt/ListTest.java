package horzsolt;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ListTest
{

    @Test(expected = UnsupportedOperationException.class)
    public void createUnmodifiableList()
    {
        List<String> list = List.of("one", "two", "three");
        assertEquals(list.size(), 3);

        list.add("four");

    }

    /*Can't add NULL */
    @Test(expected = NullPointerException.class)
    public void createUnmodifiableListWithNull()
    {
        List<String> list = List.of("one", "two", "three", null);
        assertEquals(list.size(), 3);
    }

    /**
     * Be careful, Collections.unmodifiableList returns just a view.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void isItUnmodifiable()
    {
        List<String> list = new ArrayList<>() {
            {
                add("one");
                add("two");
                add("three");
            }
        };

        List<String> unmodifiableList = Collections.unmodifiableList(list);
        assertEquals(list.size(), unmodifiableList.size());

        list.add("four");
        assertEquals(list.size(), unmodifiableList.size()); //Be careful!

        unmodifiableList.add("five"); // This is not possible, ofc.
    }
}
