public class Stack<E> {

    public static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            next = n;
            prev = p;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }
    }

    private Node<E> header = null;
    private Node<E> trailer = null;
    private int size = 0;

    public Stack() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public E top() {
        if (size == 0)
            return null;
        return trailer.getPrev().getElement();
    }

    public void push(E e) {
        Node<E> temp = new Node<E>(e, trailer.getPrev(), trailer);
        trailer.getPrev().setNext(temp);
        trailer.setPrev(temp);
        size++;
    }

    public E pop() {
        if (size == 0)
            return null;
        E temp = top();
        trailer.getPrev().getPrev().setNext(trailer);
        trailer.setPrev(trailer.getPrev().getPrev());
        size--;
        return temp;
    }

    public int size() {
        return size;
    }

}
