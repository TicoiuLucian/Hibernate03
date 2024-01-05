package org.example.service;

import org.example.dao.AnimalDAOImpl;
import org.example.dao.DAO;
import org.example.entity.Animal;

import java.util.List;
import java.util.Optional;

public class AnimalService implements Service<Animal> {

  private final DAO<Animal> animalDAO;

  public AnimalService() {
    this.animalDAO = new AnimalDAOImpl();
  }

  @Override
  public List<Animal> getAll() {
    return animalDAO.getAll();
  }

  @Override
  public Optional<Animal> getById(Integer id) {
    return animalDAO.getById(id);
  }

  @Override
  public Animal persist(Animal animal) {
    return animalDAO.persist(animal);
  }

  @Override
  public void delete(Animal animal) {
    animalDAO.delete(animal);
  }

  @Override
  public void update(Animal animal, String... args) {
    animalDAO.update(animal, args);
  }

  @Override
  public List<Animal> getByName(final String name) {
    return animalDAO.getByName(name);
  }

}