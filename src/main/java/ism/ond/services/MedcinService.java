package ism.ond.services;

import java.util.List;

import ism.ond.core.IRepository;
import ism.ond.entities.Medcin;
import ism.ond.repository.MedcinRepository;

public class MedcinService extends Service<Medcin> {

  private IRepository<Medcin> medcinRepository;

  public MedcinService(IRepository<Medcin> medcinRepository) {
    this.medcinRepository = medcinRepository;
  }

  @Override
  public Medcin selectBy(String tel) {
    return medcinRepository.selectBy(tel);
  }

  @Override
  public boolean save(Medcin data) {
    medcinRepository.save(data);
    return true;
  }

  @Override
  public List<Medcin> show() {
    return medcinRepository.selectAll();
  }

  @Override
  public <D> boolean update(Medcin data, D etat) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public <D> List<Medcin> filterBy(D data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'filterBy'");
  }

  @Override
  public List<Medcin> showDispo() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'showDispo'");
  }
  
}
