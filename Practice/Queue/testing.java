public class testing {
    public static void main(String[] args) {
        QueueClass<Integer> qs = new QueueClass<Integer>();
        qs.enqueue(3);
        qs.enqueue(4);
        qs.dequeue();
        System.out.println(qs.front());
    }
}
