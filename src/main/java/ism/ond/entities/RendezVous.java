package ism.ond.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class RendezVous {
  private int id;
  private LocalDate date;
  private LocalTime heure;
  private Medcin medcin;

}
