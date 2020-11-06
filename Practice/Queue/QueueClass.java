public class QueueClass<E> {
    private static final int MAX_Size = 1024;
    private int n = MAX_Size;
    private int f = 0;
    private int r = 0;
    private int size = 0;
    private E Q[];

    @SuppressWarnings("unchecked")
    public QueueClass() {
        // this(MAX_Size);
        Q = (E[]) new Object[n];
    }

    @SuppressWarnings("unchecked")
    public QueueClass(int cap) {
        Q = (E[]) new Object[cap];
        n = cap;
    }

    public void enqueue(E element) {
        if (size == n - 1) {
            System.out.println("Queue full");
        } else {
            Q[r] = element;
            size++;
            r = (r + 1) % n;
        }

    }

    public E dequeue() {
        if (size == 0) {
            System.out.println("Empty queue");
            return null;
        } else {
            E temp = Q[f];
            f = (f + 1) % n;
            size--;
            return temp;
        }
    }

    public E front() {
        if (size == 0) {
            System.out.println("Empty");
            return null;
        } else {
            return Q[f];
        }
    }

    public E rear() {
        if (size == 0) {
            System.out.println("Empty");
            return null;
        } else {
            return Q[r];
        }
    }
}
