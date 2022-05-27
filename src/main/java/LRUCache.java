import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache {
    private final Deque<Integer> deque;
    private final HashSet<Integer> set;
    private final int CACHE_SIZE;

    public LRUCache(int cache_size) {
        CACHE_SIZE = cache_size;
        deque = new LinkedList<>();
        set = new HashSet<>();
    }

    public void refer(int page) {
        if (set.contains(page)) {
            deque.remove(page);
        } else {
            if (deque.size() == CACHE_SIZE) {
                int last = deque.removeLast();
                set.remove(last);
            }
        }
        deque.push(page);
        set.add(page);
    }

    public void display() {
        for (Integer integer : deque) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.refer(1);
        lru.display();
        lru.refer(2);
        lru.refer(3);
        lru.display();
        lru.refer(1);
        lru.display();
        lru.refer(4);
        lru.display();

        /**
         * Deque
         * 1
         * 3 2 1
         * 1 3 2
         * 4 1 3
         */
    }
}
