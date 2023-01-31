
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SetUsingArrayTest {
    @Test
    public void test() {
        SetUsingArray<Integer> mySet = new SetUsingArray<>();
        assertEquals(true, mySet.isEmpty());
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);
        mySet.add(4);//should be ignored since duplicate
        assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, mySet.toArray());
        assertEquals(4, mySet.getCurrentSize());//4
        assertEquals(true, mySet.contains(4));
        mySet.remove(3);
        assertEquals(false, mySet.contains(3));
        mySet.remove(2);
        assertEquals(false, mySet.contains(2));
        assertEquals(2, mySet.getCurrentSize());//2
        mySet.clear();
        assertEquals(0, mySet.getCurrentSize());
        mySet.add(1);
        mySet.add(2);
        mySet.add(3); 
        assertEquals(3, mySet.getCurrentSize());//3
        
    }
    
}
