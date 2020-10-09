public class DoublyLinkedList<E> {

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

    private Node<E> header;
    private Node<E> trailer;

    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public E first() {
        if (isEmpty())
            return null;
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        return trailer.getPrev().getElement();
    }

    private void addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    private E remove(Node<E> node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
        return node.getElement();
    }

    public E removeFirst() {
        if (isEmpty())
            return null;
        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty())
            return null;
        return remove(trailer.getPrev());
    }
}
