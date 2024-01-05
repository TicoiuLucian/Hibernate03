package org.example.dao;

import org.example.entity.Caretaker;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class CaretakerDAOImpl implements DAO<Caretaker> {

  private final SessionFactory sessionFactory;
  private Session session;
  private Transaction transaction;

  public CaretakerDAOImpl() {
    this.sessionFactory = HibernateUtil.getSessionFactory();
  }

  @Override
  public List<Caretaker> getAll() {
    openSession();
    var caretakers = this.session.createQuery("SELECT c FROM Caretaker c", Caretaker.class).getResultList();
    closeSession();
    return caretakers;
  }

  @Override
  public Optional<Caretaker> getById(final Integer id) {
    openSession();
    var optionalCaretaker = Optional.ofNullable(session.get(Caretaker.class, id));
    closeSession();
    return optionalCaretaker;
  }

  @Override
  public Caretaker persist(final Caretaker caretaker) {
    openSessionAndTransaction();
    var enhancedCaretaker = session.merge(caretaker);
    closeSessionAndCommitTransaction();
    return enhancedCaretaker;
  }

  @Override
  public void delete(final Caretaker caretaker) {
    openSessionAndTransaction();
    session.remove(caretaker);
    closeSessionAndCommitTransaction();
  }

  @Override
  public void update(final Caretaker caretaker, final String... args) {

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
