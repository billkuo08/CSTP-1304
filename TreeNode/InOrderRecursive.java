class InOrderRecursive {
    TreeNode root;
  
    public void inOrder(TreeNode current) {
      if (current == null)
        return;
      inOrder(current.left);
      System.out.print(current.data + " ");
      inOrder(current.right);
    }
  
    // Driver method
    public static void main(String[] args) {
      InOrderRecursive tree = new InOrderRecursive();
      tree.root = new TreeNode(17);
      tree.root.left = new TreeNode(13);
      tree.root.right = new TreeNode(27);
  
      tree.root.left.left = new TreeNode(9);
      tree.root.left.right = new TreeNode(16);
  
      tree.root.left.left.right = new TreeNode(11);
      tree.root.right.left = new TreeNode(20);
      tree.root.right.right = new TreeNode(39);
  
      tree.inOrder(tree.root);
    }
  }

  