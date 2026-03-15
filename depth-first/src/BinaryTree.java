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

    public int leavesCouter(Node root) {
        if (root == null) return 0;
        if (root.getLeft() == null && root.getRight() == null) return 1;

        return leavesCouter(root.getLeft()) + leavesCouter(root.getRight());
    }

    public boolean searchNode(Node root, char letter) {
        if (root == null) return false;
        if (root.getData()== letter) return true;

        return searchNode(root.getRight(), letter) || searchNode(root.getLeft(), letter);
    } 

    public int depth(Node root) {
        if (root == null) return 0; 
        if (root.getLeft() == null && root.getRight() == null) return 0; 

        int leftDepth = depth(root.getLeft());
        int rightDepth = depth(root.getRight());
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * - String mostraPercorso(Node start, Node end), che produce il 
     * percorso (salendo o scendendo) che collega due nodi appartenenti 
     * allo stesso sottoalbero
     * @param first
     * @param second
     * @return
     */
    public String path(Node first, Node second) {
        // controllo primo e secondo che non siano nulli
        if (first == null) return "First node is empty";
        if (second == null) return "Second node is empty";

        // alla fine basta aggiungere il valore (devo fare value of perché non mi lascia cosare il char)
        if (first == second) return String.valueOf(second.getData()); 

        // controllo a sinistra
        if (first.getLeft() != null) {
            // buildo la stringa con la chiamata ricorsiva
            String leftPath = path(first.getLeft(), second);
            // controllo che il nodo sia stato trovato nel sottoalbero
            if (!leftPath.isEmpty()) {
                return first.getData() + " " + leftPath; // aggiorno
            }
        }

        // stessa logica di sopra 
        if (first.getRight() != null) {
            String rightPath = path(first.getRight(), second);
            if (!rightPath.isEmpty()) {
                return first.getData() + " " + rightPath;
            }
        }
        
        return "";
    }

    /**
     * int calcolaLivello(Node n), che rivela a quale livello appartiene 
     * il nodo in input (la root è a livello 1, e così via...)
     */
    public int calculateLivellate(Node n) { // quanto è bello il nome del metodo ( si legge in inglish )
        if (n == null) return 0;

        return calculateLivellateHelper(this.root, n, 1);

    }

    private int calculateLivellateHelper(Node current, Node target, int level) {
        if (current == null) return 0; // caso base null
        if (current == target) return level; // trovato!!


        // provo a sinistra
        int left = calculateLivellateHelper(current.getLeft(), target, level + 1);
        if (left != 0) return left;

        // destra
        return calculateLivellateHelper(current.getRight(), target, level + 1);
    }

    /**
     * String mostraPercorso(Node start, Node end), che produce il percorso (salendo o scendendo) 
     * che collega due nodi appartenenti allo stesso sottoalbero
     */
    public String mostraitPercorsait(Node start, Node end) {
        String result = mostraitPercorsaitHelper(start, end);
        return result;
    }

    private String mostraitPercorsaitHelper(Node current, Node end) {
        // nodo non trovato
        if (current == null) return null; // caso base

        // nodo trovato
        if (current == end) return "" + current.getData(); 

        // analizzo destra e sinistra
        String left = mostraitPercorsaitHelper(current.getLeft(), end);
        if (left != null) return current.getData() + " " + left;

        String right = mostraitPercorsaitHelper(current.getRight(), end);
        if (right != null) return current.getData() + " " + right;

        // non trovato
        return null;
    }


}
