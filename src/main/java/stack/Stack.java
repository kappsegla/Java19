package stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack {
    List<String> list = new ArrayList<>();

    public void push(String text) {
        list.add(text);
    }

    public int count() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String pop() {
        int lastIndex = list.size() -1;
        if( lastIndex < 0)
            throw new EmptyStackException();
        String s = list.get(lastIndex);
        list.remove(lastIndex);
        return s;
    }
}
