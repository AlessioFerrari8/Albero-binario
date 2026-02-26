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
    private void postOrder(Node n) {
        // exit clause
        if (n == null) return;

        postOrder(n.getLeft());
        postOrder(n.getRight());        
        System.out.print(n.getData());
    }

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
    private void inOrder(Node n) {
        // exit clause
        if (n == null) return;

        inOrder(n.getLeft());
        System.out.print(n.getData());
        inOrder(n.getRight());        
    }

    /**
     * Conta quanti nodi sono presenti nel sotto albero
     * @param root nodo di partenza
     * @return lunghezza
     */
    public int nodeCounter(Node root) {
        if (root == null) return 0; // exit clause + basic case

        return nodeCounter(root.getLeft()) + nodeCounter(root.getRight()) + 1;
    }
}
