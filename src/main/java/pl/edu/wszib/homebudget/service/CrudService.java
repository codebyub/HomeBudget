package pl.edu.wszib.homebudget.service;

import java.util.List;

public interface CrudService<T, ID> {
    List<T> list();

    T get(ID id);

    T create(T dto);

    T update(T dto);

    void delete(ID id);
}
