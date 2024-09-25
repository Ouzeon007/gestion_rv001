package ism.ond.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.ond.core.IRepository;
import ism.ond.core.config.DataSourceImpl;

public abstract class Repository<T> extends DataSourceImpl<T> implements IRepository<T> {
  
  protected String tablename;
  @Override
  public int generateId() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean save(T data) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public T selectBy(String tel) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <D> boolean update(T data, D etat) {
    // TODO Auto-generated method stub
    return false;
  }

  protected Class<T> clazz;

  protected List<T> liste = new ArrayList<>();

  public abstract T convertToObject(ResultSet rs) throws SQLException;

  @Override
  public List<T> selectAll() {
    return this.selectAll(clazz, this.tablename);
  }
  
}
