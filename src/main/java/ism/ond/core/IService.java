package ism.ond.core;

import java.util.List;

public interface IService<T> {
  T selectBy(String tel);

  boolean save(T data);

  List<T> show();

  <D> boolean update(T data, D etat);

  public <D> List<T> filterBy(D data);

  List<T> showDispo();
}
