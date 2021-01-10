package edu.behavioural;

import java.util.ArrayList;
import java.util.List;

public class SimpleListImp<T> implements SimpleList<T>{
    private final List<T> list;

    // decorate one thing
    public SimpleListImp(List<T> list) {
        this.list = list;
    }

    // in any way you want (add new method, change names, own the interface)
    public SimpleListImp(){
        list = new ArrayList<>();
    }

    @Override
    public void insert(T element) {
        list.add(element);
    }

    @Override
    public void delete(int index) {
        list.remove(index);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }
}
