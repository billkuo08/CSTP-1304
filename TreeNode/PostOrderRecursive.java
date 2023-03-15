public class PostOrderRecursive {
    TreeNode root;

    public void PostOrder(TreeNode current){
        if(current == null)
            return;            
        PostOrder(current.left);      
        PostOrder(current.right);
        System.out.println(current.data + " ");
          
    }

    public static void main (String[] args){
        PostOrderRecursive tree = new PostOrderRecursive();
        tree.root = new TreeNode(17);
        tree.root.left = new TreeNode(13);
        tree.root.right = new TreeNode(27);

        tree.root.left.left = new TreeNode(9);
        tree.root.left.right = new TreeNode(16);

        tree.root.left.left.right = new TreeNode(11);
        tree.root.right.left = new TreeNode(20);
        tree.root.right.right = new TreeNode(39);

        tree.PostOrder(tree.root);// 11 9 16 13 20 39 27 17 


    }
}
