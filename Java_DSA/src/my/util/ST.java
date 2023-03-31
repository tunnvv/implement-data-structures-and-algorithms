package my.util;

public interface ST<Key, Value> {
    void put(Key key, Value value);
    Value get(Key key);
    void pop(Key key);
    Iterable<Key> keys();
    int size();
}
