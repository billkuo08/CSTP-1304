
// This is gonna be an implenentaion of a stack (adt) using an array(CDT)
public class StackUsingArray {
    //////////////////
    // Data Members //
    //////////////////
    Integer[] arr; // declaration
    int top; // declaration
  
  
    ///////////////////////
    // Member Functions  //
    //////////////////////
    // constructor
    // 1 - same name as the class
    // 2 - should be public
    // 3- does not return any thing
    // 4 - if it is a 'default' constructor, we should not pass any inputs
    StackUsingArray() {
      // this is the array CDT we plan to use to implement the stack
      final int maxArraySize = 10;
      arr = new Integer[maxArraySize]; // Initialization
      top = -1; // Initialization
    }
  
    // a mutator method to add an element to the top of the stack
    void push(int anElement) {
      top += 1;
      arr[top] = anElement;
    }
  
    // a mutator method to remove an element to the top of the stack
    void pop() {
      top--;
    }
  
    // a accessor to get the element on the top of the stack
    // return -266 if the stack is empty
    int peek() {
      if (top != -1)
        return arr[top];// Todo
      else
        return -266;
    }
  }
 