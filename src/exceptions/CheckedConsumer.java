package exceptions;

@FunctionalInterface
public interface CheckedConsumer<T> {
    void apply(T t) throws Exception;
}
