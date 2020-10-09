public class test {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.addFirst(5);
        list.addFirst(3);
        list.removeLast();
        System.out.println(list.last());
    }
}
