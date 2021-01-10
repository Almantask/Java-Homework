package edu.behavioural;

public interface SimpleList<T> {
    void insert(T element);
    void delete(int index);
    T get(int index);
}
