package ism.ond.entities;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Medcin {
  private int id;
  private String nom;
  private String prenom;
  private List<RendezVous> RVS;
}
