public class BinaryTree {
    private Node root; // head

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Node n) {
        this.root = n;
    }
    
    public void preOrder() {
        preOrder(root);
    }

    // depth first

    // in order
    
    /**
     * I nodi genitori sono visitati prima dei figli
     * @param n
     */
    private void preOrder(Node n) {
        // exit clause
        if (n == null) return;

        System.out.print(n.getData());
        preOrder(n.getLeft());
        preOrder(n.getRight());
    }

    // post order
}
