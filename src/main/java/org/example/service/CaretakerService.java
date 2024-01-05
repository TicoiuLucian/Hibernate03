package org.example.service;

import org.example.dao.CaretakerDAOImpl;
import org.example.dao.DAO;
import org.example.entity.Animal;
import org.example.entity.Caretaker;

import java.util.List;
import java.util.Optional;

public class CaretakerService implements Service<Caretaker> {
  private final DAO<Caretaker> caretakerDao;
  private final Service<Animal> animalService;

  public CaretakerService() {
    this.animalService = new AnimalService();
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
    for (Animal animal : caretaker.getAnimals()) {
      var animalList = animalService.getByName(animal.getName());
      if (!animalList.isEmpty()) {
        System.out.println("Animal " + animal.getName() + "  already exists in database");
        animal.setId(animalList.get(0).getId());
        animalList.get(0)
                .getCaretakers().forEach(animal::addCaretaker);

      }
    }
    return caretakerDao.persist(caretaker);
  }

  @Override
  public void delete(final Caretaker caretaker) {
    caretakerDao.delete(caretaker);
  }

  @Override
  public void update(final Caretaker caretaker, final String... args) {

  }

  @Override
  public List<Caretaker> getByName(final String name) {
    return caretakerDao.getByName(name);
  }
}
