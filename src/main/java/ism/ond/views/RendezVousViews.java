package ism.ond.views;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import ism.ond.core.IService;
import ism.ond.entities.Medcin;
import ism.ond.entities.RendezVous;

public class RendezVousViews extends Views<RendezVous> {
  private IService<Medcin> medecinService;
  private IService<RendezVous> rendezVousService;

  public RendezVousViews(Scanner scanner, IService<Medcin> medecinService, IService<RendezVous> rendezVousService) {
    super(scanner);
    this.medecinService = medecinService;
    this.rendezVousService = rendezVousService;
  }


  @Override
  public RendezVous create() {
    Medcin medcin;
    do {
      System.out.println("entrer le nom du medcin attache a ce rendez vous");
      medcin = medecinService.selectBy(scanner.next());
    }while (medcin == null);
    RendezVous rendezVous = new RendezVous();
    rendezVous.setDate(LocalDate.now());
    rendezVous.setHeure(LocalTime.now());
    rendezVous.setMedcin(medcin);
    medcin.getRVS().add(rendezVous);

    return rendezVous;
  }

  @Override
  public RendezVous give() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'give'");
  }

}
