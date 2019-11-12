package patterns.fluent;

import com.google.gson.Gson;
import com.google.gson.internal.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class FluentApi {
    private String text = "";
    private int id = 0;
    private double price;

   public String getText() {
        return text;
    }

    public FluentApi setText(String text) {
        this.text = text;
        return this;
    }

    public int getId() {
        return id;
    }

    public FluentApi setId(int id) {
        this.id = id;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public FluentApi setPrice(double price) {
        this.price = price;
        return this;
    }

    public static void main(String[] args) {
        FluentApi fluentApi = new FluentApi();
        fluentApi.setText("Text")
                .setId(10)
                .setPrice(2.0);

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        long count = stream
                .filter(i -> i % 2 == 0)
                .map(v -> v.toString())
                .count();
    }
}


