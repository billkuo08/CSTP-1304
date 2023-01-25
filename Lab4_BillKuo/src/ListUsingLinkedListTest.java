package src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ListUsingLinkedListTest {
  @Test
  public void test() {
    List x = new ListUsingLinkedList();
    // Position starts from 1
    x.add(10);
    x.add(20);
    x.add(30);
    assertEquals(30, x.get(3));// 30
    x.add(1, 5);
    assertEquals(20, x.get(3));// 20
    x.remove(3); // 20
    assertEquals(3, x.size());// 3
  }
}
