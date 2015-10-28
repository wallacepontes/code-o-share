package org.codeoshare.designpatterns.creational.objectpool;

public interface Pool<T> {
    T acquire();
    void release(T t);
}
