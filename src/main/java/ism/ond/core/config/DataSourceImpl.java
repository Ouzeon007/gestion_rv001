package ism.ond.core.config;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ism.ond.core.DataSource;

public class DataSourceImpl<T> implements DataSource<T> {

  protected Connection connection;
  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String URL = "jdbc:mysql://localhost:3306/gestion_rv001";
  private static final String UTILISATEUR = "root";
  private static final String PASSWORD = "";
  protected PreparedStatement ps;

  @Override
  public void closeConnection() throws SQLException {
    if (connection != null && !connection.isClosed()) {

      connection.close();
    }
  }

  @Override
  public void getConnection() throws SQLException {
    try {
      Class.forName(DRIVER);
      connection = DriverManager.getConnection(URL, UTILISATEUR, PASSWORD);
    } catch (ClassNotFoundException e) {
      System.out.println("Erreur de chargement du Driver");
      e.printStackTrace();
    }
  }

  @Override
  public ResultSet executeQuery() throws SQLException {

    return ps.executeQuery();
  }

  @Override
  public int executeUpdate() throws SQLException {

    return ps.executeUpdate();
  }

  @Override
  public void initPreparedStatement(String sql, List<Object> params) throws SQLException {
    this.getConnection();
    if (sql.toUpperCase().trim().startsWith("INSERT")) {
      ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    } else {
      ps = connection.prepareStatement(sql);
    }
    this.setParameters(params);
  }

  public void setParameters(List<Object> params) {
    try {
      for (int i = 0; i < params.size(); i++) {
        ps.setObject(i + 1, params.get(i));
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
      e.printStackTrace();
    }
  }

  @Override
  public String generatSql(T data) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setField(String field, String value) {
    // TODO Auto-generated method stub

  }

  public List<T> selectAll(Class<T> clazz, String tableName) {
    List<T> listes = new ArrayList<>();
    try {
      String sql = String.format("SELECT * FROM %s", tableName);
      this.initPreparedStatement(sql, new ArrayList<>());
      ResultSet re = this.executeQuery();

      while (re.next()) {
        listes.add(this.convertToObject(re, clazz));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        this.closeConnection();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return listes;

  }

  public T convertToObject(ResultSet rs, Class<T> clazz) throws Exception {
    try {
      T obj = clazz.getConstructor().newInstance();
      for (Field field : clazz.getDeclaredFields()) {
        field.setAccessible(true);
        String coloneName = field.getName();
        Object value = rs.getObject(coloneName);
        if (field.getType().isEnum()) {
          String enumValue = (String) value;
          Object enumConstant = Enum.valueOf((Class<Enum>) field.getType(), enumValue);
          field.set(obj, enumConstant);
        } else {
          field.set(obj, value);
        }
      }

      return obj;
    } catch (Exception e) {
      throw e;
    }
  }

}
