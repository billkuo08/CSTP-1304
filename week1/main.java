package week1;
class Main {

    public static void main(String[] args) {
        System.out.println("test");
        //StackUsingArray aStack = new StackUsingArray();
        StackUsingLinkList aStack = new StackUsingLinkList();
        aStack.push(1);
        aStack.push(2);

        //Test Case 1
        //System.out.println(aStack.peek());//2 Expected

        //Test Case 2
        // aStack.pop();//2 should be removed
        // System.out.println(aStack.peek()); //1 expected

        //Test Case 3 - test an empty stack
        aStack.pop();
        aStack.pop();
        System.out.println(aStack.peek());//Expected -266

    }
}

