import java.util.Stack;
import java.util.Vector;

public class Tree<E> {
    public static class Node<E> {
        public E e;
        public Node<E> left, right;

        public Node(E element) {
            e = element;
            left = right = null;
        }
    }

    Node<E> root;

    Tree() {
        root = null;
    }

    void printPreOrder(Node<E> node) {
        if (node == null)
            return;
        System.out.print(node.e + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    void printPostOrder(Node<E> node) {
        if (node == null)
            return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.e + " ");
    }

    void printInOrder(Node<E> node) {
        if (node == null)
            return;
        printInOrder(node.left);
        System.out.print(node.e + " ");
        printInOrder(node.right);
    }

    void printPreOrderIter(Node<E> node) {
        Stack<Node<E>> st = new Stack<Node<E>>();
        st.push(node);
        while (!st.empty()) {
            System.out.print(st.peek().e + " ");
            Node<E> nodeL = st.peek().left;
            Node<E> nodeR = st.peek().right;
            st.pop();
            if (nodeR != null)
                st.push(nodeR);
            if (nodeL != null)
                st.push(nodeL);
        }
    }

    void printInOrderIter(Node<E> node) {
        Stack<Node<E>> st = new Stack<Node<E>>();
        Node<E> cur = node;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.peek();
            st.pop();
            System.out.print(cur.e + " ");
            cur = cur.right;
        }
    }

    void printPostOrderIter(Node<E> node) {
        Stack<Node<E>> st1 = new Stack<Node<E>>();
        Stack<Node<E>> st2 = new Stack<Node<E>>();
        Node<E> cur = node;
        st1.push(cur);
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
            if (st2.peek().left != null)
                st1.push(st2.peek().left);
            if (st2.peek().right != null)
                st1.push(st2.peek().right);
        }
        while (!st2.isEmpty()) {
            System.out.print(st2.peek().e + " ");
            st2.pop();
        }
    }

    // public boolean checkBST() {
    // return checkBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    // }

    // public boolean checkBSTUtil(Node<E> node, int min, int max) {
    // if (node == null)
    // return true;

    // if (node.e.compareTo(min) < 0 || node.e.compareTo(max) > 0)
    // return false;

    // return (checkBSTUtil(node.left, min, (int) node.e - 1) &&
    // checkBSTUtil(node.right, (int) node.e + 1, max));
    // }

    public Boolean helper(Node<Integer> root, Vector<Integer> v, int n) {
        if (root == null)
            return false;
        v.add(root.e);

        if (root.e == n)
            return true;
        if (helper(root.left, v, n) || helper(root.right, v, n))
            return true;

        v.remove(v.size() - 1);
        return false;
    }

    public void path(Node<Integer> root, int x, int y) {

        Vector<Integer> p1 = new Vector<Integer>();
        Vector<Integer> p2 = new Vector<Integer>();

        helper(root, p1, x);
        helper(root, p2, y);

        int intersect = -1;

        int i = 0, j = 0;
        while (i != p1.size() || j != p2.size()) {
            if (i == j && p1.get(i) == p2.get(j)) {
                i++;
                j++;
            } else {
                intersect = j - 1;
                break;
            }
        }
        String ans = "";
        for (int k = p1.size() - 1; k > intersect; k--) {
            ans += p1.get(k);
            ans += " ";
        }

        for (int k = intersect; k < p2.size(); k++) {
            ans += p2.get(k);
            ans += " ";
        }

        System.out.println(ans);
    }

    private int minHelper(Node<E> root, int result) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return (int) root.e;
        int leftSum = minHelper(root.left, result);
        int rightSum = minHelper(root.right, result);

        if (root.left == null && root.right != null)
            return (int) root.e + rightSum;
        else if (root.left != null && root.right == null)
            return (int) root.e + leftSum;
        else {
            result = Math.min(result, (int) root.e + leftSum + rightSum);
            return Math.min((int) root.e + leftSum, (int) root.e + rightSum);
        }
    }

    public int minimumSumPath(Node<E> root) {
        int result = Integer.MAX_VALUE;
        int ans = minHelper(root, result);
        return ans;
    }

    int counter = 0;

    private int LinSearch(E arr[], int start, int end, E key) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == key)
                return i;
        }
        return i;
    }

    public Node buildTree(E inorder[], E preorder[], int start, int end) {
        Node n = new Node(preorder[counter++]);

        if (start > end)
            return null;

        if (start == end)
            return n;

        int indexInorder = LinSearch(inorder, start, end, (E) n.e);

        n.left = buildTree(inorder, preorder, start, indexInorder - 1);
        n.right = buildTree(inorder, preorder, indexInorder + 1, end);

        return n;

    }

    public static void main(String[] args) {

        Tree<Integer> temp = new Tree<Integer>();

        temp.root = new Node<Integer>(1);
        temp.root.left = new Node<Integer>(2);
        temp.root.right = new Node<Integer>(5);
        temp.root.left.left = new Node<Integer>(3);
        temp.root.left.right = new Node<Integer>(4);
        temp.root.left.right.left = new Node<Integer>(6);
        temp.root.left.right.right = new Node<Integer>(7);
        // temp.printPostOrder(temp.root);
        // System.out.println();
        // temp.printPostOrderIter(temp.root);

        temp.path(temp.root, 3, 6);

        // System.out.println(temp.minimumSumPath(temp.root));

        // Tree<Integer> tree2 = new Tree<Integer>();
        // Integer inorder[] = new Integer[] { 3, 2, 1, 5, 6, 4, 8, 7, 9 };
        // Integer preorder[] = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // Node root = tree2.buildTree(inorder, preorder, 0, 8);
        // tree2.printPostOrder(root);
    }
}