package ism.ond.views;

import java.util.List;
import java.util.Scanner;

import ism.ond.entities.Medcin;

public class MedcinViews extends Views<Medcin> {
  
  public MedcinViews(Scanner scanner) {
    super(scanner);
  }

  @Override
  public Medcin create() {
    Medcin medcin = new Medcin();
    do {
      System.out.println("entrer le nom du medcin");
      medcin.setNom(scanner.next());
    } while (medcin.getNom().isEmpty());

    do {
      System.out.println("entrer le prenom du medcin");
      medcin.setPrenom(scanner.next());
    } while (medcin.getPrenom().isEmpty());
    return medcin;
  }

  @Override
  public Medcin give() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'give'");
  }
  
}
