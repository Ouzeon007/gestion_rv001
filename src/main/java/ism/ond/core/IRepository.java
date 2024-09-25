package ism.ond.core;

import java.util.List;

public interface IRepository<T> {
  T selectBy(String tel);

  boolean save(T data);

  List<T> selectAll();

  <D> boolean update(T data, D etat);

  int generateId();
}
