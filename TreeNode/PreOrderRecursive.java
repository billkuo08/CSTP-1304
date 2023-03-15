public class PreOrderRecursive {
    TreeNode root;
    
    public void preOrder(TreeNode current){
        if(current == null)
            return;
        System.out.println(current.data + " ");
        preOrder(current.left);
        preOrder(current.right);            
    }

    public static void main (String[] args){
        PreOrderRecursive tree = new PreOrderRecursive();
        tree.root = new TreeNode(17);
        tree.root.left = new TreeNode(13);
        tree.root.right = new TreeNode(27);

        tree.root.left.left = new TreeNode(9);
        tree.root.left.right = new TreeNode(16);

        tree.root.left.left.right = new TreeNode(11);
        tree.root.right.left = new TreeNode(20);
        tree.root.right.right = new TreeNode(39);

        tree.preOrder(tree.root); // 17 13 9 11 16 27 20 39

    }
    
}
