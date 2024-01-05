package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Animal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(unique = true, name = "animal_name")
  private String name;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private List<Caretaker> caretakers = new ArrayList<>();

  public Animal(String name) {
    this.name = name;
  }

  public void addCaretaker(final Caretaker caretaker) {
    this.caretakers.add(caretaker);
  }
}
