package ism.ond.views;

import java.util.List;
import java.util.Scanner;

import ism.ond.core.IViews;

public abstract class Views<T> implements IViews<T>  {
  
  protected Scanner scanner;

  public Views(Scanner scanner) {
    this.scanner = scanner;

  }

    @Override
  public void affiche(List<T> datas) {
    for (T data : datas) {
      System.out.println(data);
    }
  }
}
