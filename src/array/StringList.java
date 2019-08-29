package array;

import java.util.Arrays;

public class StringList {

    private String[] array;
    private int count;

    public StringList() {
        //Create an array
        array = new String[10];
    }

    public StringList(int startSize) {
        //Create an array
        array = new String[startSize];
    }

    /**
     * Adds string s to end of list
     *
     * @param s String to add
     */
    public void add(String s) {
        if (count > array.length - 1) {
            //Create new array with more space
            String[] newArray = new String[array.length + (int)(array.length * 0.5)];
            //Copy old array to new array
            

            //Remove old array

        }
        array[count] = s;
        count++;
    }

    /**
     * Returns the element at the specified position
     *
     * @param index Position of element, >= 0
     * @return Reference to element
     */
    public String get(int index) {
        return array[index];
    }

    /**
     * Returns the number of elements stored in this list.
     *
     * @return Number of elements
     */
    public int size() {
        return count;
    }
}
