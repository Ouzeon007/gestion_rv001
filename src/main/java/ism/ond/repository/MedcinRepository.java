package ism.ond.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import ism.ond.entities.Medcin;

public class MedcinRepository extends Repository<Medcin> {

  public MedcinRepository() {
    this.tablename = "Medecin";
    this.clazz = Medcin.class;
  }

  @Override
  public Medcin selectBy(String nom) {
    Medcin medecin = null;
    List<Object> params = new ArrayList<>();
    params.add(nom);

    try {
      String sql = String.format("SELECT * FROM %s WHERE telephone = ?", this.tablename);
      this.initPreparedStatement(sql, params);

      ResultSet rs = this.executeQuery();
      while (rs.next()) {
        medecin = this.convertToObject(rs);
      }

      rs.close();
      return medecin;

    } catch (SQLException e) {
      System.out.println("Erreur de Connexion à la base de données : " + e.getMessage());
      e.printStackTrace();
    } finally {
      try {
        this.closeConnection();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return null;
  }


    @Override
  public List<Medcin> selectAll() {
    List<Medcin> medecins = new ArrayList<>();
    try {
      String sql = String.format("SELECT * FROM %s", this.tablename);
      this.initPreparedStatement(sql, new ArrayList<>());
      ResultSet rs = executeQuery();

      while (rs.next()) {
        medecins.add(this.convertToObject(rs));
      }
      rs.close();
    } catch (SQLException e) {
      System.out.println("Erreur lors de la récupération des utilisateurs: " + e.getMessage());
      e.printStackTrace();
    } finally {
      try {
        this.closeConnection();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return medecins;
  }

  @Override
  public boolean save(Medcin medcin) {
    try {
      List<Object> params = this.queryCMedecin(medcin);
      String sql = String.format("INSERT INTO %s ( `nom`, `prenom`) VALUES (?,?)",
          this.tablename);
      this.initPreparedStatement(sql, params);
      ResultSet rs = this.ps.getGeneratedKeys();
      if (rs.next()) {
        medcin.setId(rs.getInt(1));
      }
      this.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        this.closeConnection();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return true;
  }

  public  List<Object> queryCMedecin(Medcin medcin) {
    List<Object> params = new ArrayList<>();
    params.add(medcin.getNom());
    params.add(medcin.getPrenom());
    return params;
  }


  @Override
  public Medcin convertToObject(ResultSet rs) throws SQLException {
    Medcin medcin = new Medcin();
    medcin.setId(rs.getInt("id"));
    medcin.setNom(rs.getString("nom"));
    medcin.setPrenom(rs.getString("prenom"));

    return medcin;
  }

}
