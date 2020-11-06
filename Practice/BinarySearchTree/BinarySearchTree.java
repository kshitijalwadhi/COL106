public class BinarySearchTree {
    public class Node {
        public int element;
        public Node leftChild;
        public Node rightChild;
        public Node parent;

        public Node(int e) {
            element = e;
            leftChild = null;
            rightChild = null;
            parent = null;
        }

        public Node(int e, Node l, Node r, Node p) {
            element = e;
            leftChild = l;
            rightChild = r;
            parent = p;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    public int minima() {
        return minValue(root);
    }

    public int minValue(Node n) {
        int minValue = n.element;

        while (n.leftChild != null) {
            minValue = n.leftChild.element;
            n = n.leftChild;
        }
        return minValue;
    }

    public int maxima() {
        return maxValue(root);
    }

    public int maxValue(Node n) {
        int maxValue = n.element;

        while (n.rightChild != null) {
            maxValue = n.rightChild.element;
            n = n.rightChild;
        }
        return maxValue;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.element)
            root.leftChild = insertRec(root.leftChild, key);
        else if (key > root.element)
            root.rightChild = insertRec(root.rightChild, key);

        return root;
    }

    public boolean search(int key) {
        if (searchRec(root, key) == null)
            return false;
        return true;
    }

    public Node searchRec(Node root, int key) {
        if (root == null || root.element == key)
            return root;
        if (key < root.element)
            return searchRec(root.leftChild, key);
        else if (key > root.element)
            return searchRec(root.rightChild, key);
        return root;
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    public Node deleteRec(Node root, int key) {
        if (root == null)
            return null;
        if (key < root.element)
            root.leftChild = deleteRec(root.leftChild, key);
        else if (key > root.element)
            root.rightChild = deleteRec(root.rightChild, key);

        else {
            if (root.leftChild == null)
                return root.rightChild;
            else if (root.rightChild == null)
                return root.leftChild;

            root.element = maxValue(root.leftChild);
            root.leftChild = deleteRec(root.leftChild, root.element);
        }
        return root;
    }

    void printPreOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.element + " ");
        printPreOrder(node.leftChild);
        printPreOrder(node.rightChild);
    }

    public void createMinimalBST(int[] arr) {
        root = minimalBSTRec(arr, 0, arr.length - 1);
    }

    public Node minimalBSTRec(int[] arr, int start, int end) {
        if (end < start)
            return null;
        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);
        n.leftChild = minimalBSTRec(arr, start, mid - 1);
        n.rightChild = minimalBSTRec(arr, mid + 1, end);
        return n;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(7);
        tree.insert(3);
        tree.insert(9);
        tree.insert(8);
        tree.insert(11);
        tree.insert(1);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);

        tree.delete(3);

        // tree.printPreOrder(tree.root);
        // System.out.println(tree.search(4));

        BinarySearchTree tree2 = new BinarySearchTree();

        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        tree2.createMinimalBST(arr);
        tree2.printPreOrder(tree2.root);
    }
}
