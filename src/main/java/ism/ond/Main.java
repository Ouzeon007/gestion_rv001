package ism.ond;

import java.util.Scanner;

import ism.ond.core.IRepository;
import ism.ond.core.IService;
import ism.ond.core.IViews;
import ism.ond.entities.Medcin;
import ism.ond.entities.RendezVous;
import ism.ond.repository.MedcinRepository;
import ism.ond.repository.RenderVousRepository;
import ism.ond.services.MedcinService;
import ism.ond.services.RendezVousService;
import ism.ond.views.MedcinViews;
import ism.ond.views.RendezVousViews;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        IRepository<Medcin> medecinRepository =new MedcinRepository();
        IRepository<RendezVous> rendezVousRepository =new RenderVousRepository();
        IService<Medcin> medcinService =new MedcinService(medecinRepository);
        IService<RendezVous> rendezVousService =new RendezVousService(rendezVousRepository);
        IViews<Medcin> medcinViews = new MedcinViews(scanner);
        IViews<RendezVous> rendezVousViews = new RendezVousViews(scanner, medcinService, rendezVousService);

        int choix;
        do {
            choix = menu();
            switch (choix) {
                case 1 -> {
                    medcinService.save(medcinViews.create());
                }
                case 2 -> {
                    medcinService.show();
                }
                case 3 -> {
                    rendezVousService.save(rendezVousViews.create());
                }
            }

    }while (choix != 13); 
}

    public static int menu() {
        System.out.println("-------------------------------------------");
        System.out.println("1- Ajouter un Medcin");
        System.out.println("2- Lister les Medcins");
        System.out.println("3- Ajouter un Rendez-vous");
        System.out.println("13- Quitter");
        System.out.println("-------------------------------------------");

        return scanner.nextInt();
    }
}
