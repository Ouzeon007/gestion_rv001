package ism.ond.core;

import java.util.List;

public interface IViews<T> {
  
  T create();

  void affiche(List<T> object);

  T give();
}