import java.util.Stack;

class InOrderIterative {
  TreeNode root;

  public void inOrder() {

    Stack<TreeNode> aStack = new Stack<>();
    TreeNode current = root;

    while (current != null || !aStack.isEmpty()) {

      // Find leftmost node with no left child
      while (current != null) {
        aStack.push(current);
        current = current.left;
      }

      // Visit leftmost node, then traverse its right subtree
      if (!aStack.empty()) {
        TreeNode next = aStack.pop();
        System.out.println(next.data);
        current = next.right;
      }
    }

  }

  // Driver method
  public static void main(String[] args) {
    InOrderIterative tree = new InOrderIterative();
    tree.root = new TreeNode(17);
    tree.root.left = new TreeNode(13);
    tree.root.right = new TreeNode(27);

    tree.root.left.left = new TreeNode(9);
    tree.root.left.right = new TreeNode(16);

    tree.root.left.left.right = new TreeNode(11);
    tree.root.right.left = new TreeNode(20);
    tree.root.right.right = new TreeNode(39);

    tree.inOrder(); // 9 11 13 16 17 20 27 39
  }
}