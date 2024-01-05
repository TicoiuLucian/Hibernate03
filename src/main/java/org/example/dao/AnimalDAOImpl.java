package org.example.dao;

import org.example.entity.Animal;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class AnimalDAOImpl implements DAO<Animal> {

  private final SessionFactory sessionFactory;
  private Session session;
  private Transaction transaction;

  public AnimalDAOImpl() {
    this.sessionFactory = HibernateUtil.getSessionFactory();
  }

  @Override
  public List<Animal> getAll() {

    openSession();
    List<Animal> animals = this.session.createQuery("SELECT a FROM Animal a", Animal.class).getResultList();
    closeSession();
    return animals;
  }

  @Override
  public Optional<Animal> getById(Integer id) {
    openSession();
    Optional<Animal> animal = Optional.ofNullable(session.get(Animal.class, id));
    closeSession();
    return animal;
  }

  @Override
  public Animal persist(Animal animal) {
    openSessionAndTransaction();
    Animal persistedAnimal = session.merge(animal);
    closeSessionAndCommitTransaction();
    return persistedAnimal;
  }

  @Override
  public void delete(Animal animal) {
    openSessionAndTransaction();
    this.session.remove(animal);
    closeSessionAndCommitTransaction();

  }

  @Override
  public void update(Animal animal, String... args) {
    openSessionAndTransaction();

    if (args.length % 2 != 0) {
      throw new IllegalArgumentException("Arguments should be provided in field-value pairs");
    }

    for (int i = 0; i < args.length; i += 2) {
      String field = args[i];
      String value = args[i + 1];
      if ("name".equals(field)) {
        animal.setName(value);
        session.merge(animal);
      }
    }
    closeSessionAndCommitTransaction();
  }

  private void openSessionAndTransaction() {
    this.session = sessionFactory.openSession();
    this.transaction = session.beginTransaction();
  }

  private void closeSessionAndCommitTransaction() {
    this.transaction.commit();
    this.session.close();
  }

  private void openSession() {
    this.session = sessionFactory.openSession();
  }

  private void closeSession() {
    this.session.close();
  }
}
