package generics;

public class Storage<T> {

    T store;

    void add(T o){
        store = o;
    }

    T get(){
        return store;
    }
}
