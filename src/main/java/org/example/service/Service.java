package org.example.service;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
  List<T> getAll();

  Optional<T> getById(Integer id);

  T persist(T t);

  void delete(T t);

  void update(T t, String... args);

  boolean exists(String animalName);
}
