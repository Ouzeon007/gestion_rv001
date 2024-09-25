package ism.ond.services;

import java.util.List;

import ism.ond.core.IRepository;
import ism.ond.entities.RendezVous;

public class RendezVousService extends Service<RendezVous> {
  private IRepository<RendezVous> rendezVousRepository;

  public RendezVousService(IRepository<RendezVous> rendezVousRepository) {
    this.rendezVousRepository = rendezVousRepository;
  }

  @Override
  public RendezVous selectBy(String tel) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'selectBy'");
  }

  @Override
  public boolean save(RendezVous data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }

  @Override
  public List<RendezVous> show() {
    return rendezVousRepository.selectAll();
  }

  @Override
  public <D> boolean update(RendezVous data, D etat) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public <D> List<RendezVous> filterBy(D data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'filterBy'");
  }

  @Override
  public List<RendezVous> showDispo() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'showDispo'");
  }
  
}
