import java.util.*;

public class SpecialQueue {
    Deque<Integer> dq;

    public SpecialQueue() {
        dq = new LinkedList<>();
    }

    void enque(int data) {
        while (!dq.isEmpty() && dq.getLast() > data) {
            dq.removeLast();
        }
        dq.addLast(data);
    }

    void deque() {
            dq.removeFirst();
    }

    int getMin() throws Exception {
        if(dq.isEmpty())
            throw new Exception("DQueue is Empty");
        else
            return dq.getFirst();

    }

    int getMax() throws Exception{
        if(dq.isEmpty())
            throw new Exception("DQueue is Empty");
        else
            return dq.getLast();
    }

    void to_display(){
        System.out.println(dq);
    }

    public static void main(String[] args) throws Exception {
        long a = System.currentTimeMillis();
        SpecialQueue arr = new SpecialQueue();
        arr.enque(1);
        arr.to_display();
        arr.enque(2);
        arr.to_display();
        arr.enque(4);
        arr.to_display();
        System.out.println("min="+arr.getMin());
        System.out.println("max="+arr.getMax());
        arr.deque();
        arr.to_display();
        System.out.println("min="+arr.getMin());
        System.out.println("max="+arr.getMax());
        arr.enque(3);
        arr.to_display();
        System.out.println("min="+arr.getMin());
        System.out.println("max="+arr.getMax());
        arr.deque();
        arr.to_display();
        System.out.println("min="+arr.getMin());
        System.out.println("max="+arr.getMax());
        arr.enque(1);
        arr.to_display();
        System.out.println("min="+arr.getMin());
        System.out.println("max="+arr.getMax());
        arr.enque(5);
        arr.to_display();
        System.out.println("min="+arr.getMin());
        System.out.println("max="+arr.getMax());
        arr.enque(1);
        arr.deque();
        arr.to_display();
        System.out.println("min="+arr.getMin());
        System.out.println("max="+arr.getMax());
        System.out.println(System.currentTimeMillis()-a);
    }
}
