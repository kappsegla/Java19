package patterns.objectpool;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Supplier;

public class ObjectPool<T> {

    //Generic
    //Hold threadsafe queue of objects
    private Queue<T> queue = new ConcurrentLinkedQueue<>();
    private Supplier<T> supplier;
    //Initialize minobjects
    public ObjectPool(int minObjects, Supplier<T> creator) {

        if (minObjects < 0)
            throw new IllegalArgumentException();
        supplier = creator;
        for (int i = 0; i < minObjects; i++) {
            queue.add(supplier.get());
        }
    }

    //borrow object
    public T borrowObject() {
        if (!queue.isEmpty())
            return queue.poll();
        return supplier.get();
    }

    //return object
    public void returnObject(T object) {
        queue.add(object);
    }
}
