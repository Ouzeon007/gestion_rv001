package ism.ond.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DataSource<T> {
  
  void closeConnection() throws SQLException;

  void getConnection() throws SQLException;

  ResultSet executeQuery() throws SQLException;

  int executeUpdate() throws SQLException;

  String generatSql(T data);

  void setField(String field, String value);

  void initPreparedStatement(String sql, List<Object> params) throws SQLException;

}
