package org.example;

public interface ICRUD {
    Object add();
    int update(Object o);

    int delete(Object o);

    void select(int id);


}
