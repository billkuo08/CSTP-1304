package src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ListUsingLinkedListTest {
  @Test
  public void test() throws Exception {
    List<Integer> x = new ListUsingLinkedList<Integer>();
    // Position starts from 1
    x.add(10);
    x.add(20);
    x.add(30);
    int y = x.get(3);
    assertEquals(30, y);// 30
    x.add(1, 5);
    int z = x.get(3);
    assertEquals(20, z);// 20
    x.remove(3); // 20
    assertEquals(3, x.size());// 3
  }
}
