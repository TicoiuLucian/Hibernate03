package org.example.service;

import org.example.dao.CaretakerDAOImpl;
import org.example.dao.DAO;
import org.example.entity.Caretaker;

import java.util.List;
import java.util.Optional;

public class CaretakerService implements Service<Caretaker> {
  private final DAO<Caretaker> caretakerDao;

  public CaretakerService() {
    this.caretakerDao = new CaretakerDAOImpl();
  }

  @Override
  public List<Caretaker> getAll() {
    return caretakerDao.getAll();
  }

  @Override
  public Optional<Caretaker> getById(final Integer id) {
    return caretakerDao.getById(id);
  }

  @Override
  public Caretaker persist(final Caretaker caretaker) {
    return caretakerDao.persist(caretaker);
  }

  @Override
  public void delete(final Caretaker caretaker) {
    caretakerDao.delete(caretaker);
  }

  @Override
  public void update(final Caretaker caretaker, final String... args) {

  }
}
