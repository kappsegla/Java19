package patterns.objectpool;

public class Test {
    public static void main(String[] args) {

        ObjectPool<Reusable> reusableObjectPool = new ObjectPool<>(2, Reusable::new);

        //ObjectPool<String> stringObjectPool = new ObjectPool<>(2,String::new);

        Reusable reusable = reusableObjectPool.borrowObject();
        Reusable reusable2 = reusableObjectPool.borrowObject();
        reusableObjectPool.returnObject(reusable);
        reusableObjectPool.returnObject(reusable2);

        reusable = reusableObjectPool.borrowObject();

        reusable.doSomething();

        System.out.println(reusable.counter);
    }
}
