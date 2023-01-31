import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SetUsingLinkedListTest {

    @Test
    public void test() {
        SetUsingLinkedList<Integer> mySet = new SetUsingLinkedList<>();
        assertEquals(0, mySet.getCurrentSize());
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);
        mySet.add(4);//should be ignored since duplicate
        assertEquals(4, mySet.getCurrentSize());//4
        mySet.add(5);
        assertEquals(true, mySet.contains(4));
        mySet.remove(3);
        assertEquals(false, mySet.contains(3));
        assertEquals(4, mySet.getCurrentSize());//4
        mySet.clear();
        assertEquals(0, mySet.getCurrentSize());

        
    }
}
