package org.example;

import org.example.entity.Animal;
import org.example.entity.Caretaker;
import org.example.service.AnimalService;
import org.example.service.CaretakerService;
import org.example.service.Service;

public class Main {
  public static void main(String[] args) {
    Service<Caretaker> caretakerService = new CaretakerService();

    Caretaker marcel = new Caretaker();
    marcel.setCaretakerName("Marcel");
    marcel.setAge(35);

    Caretaker ion = new Caretaker();
    ion.setCaretakerName("Ion");
    ion.setAge(27);

    Caretaker daniel = new Caretaker();
    daniel.setCaretakerName("Daniel");
    daniel.setAge(21);

    marcel.addAnimal(new Animal("Lion"));
    marcel.addAnimal(new Animal("Tiger"));
    caretakerService.persist(marcel);

    ion.addAnimal(new Animal("Deer"));
    ion.addAnimal(new Animal("Mouse"));
    ion.addAnimal(new Animal("Tiger"));
    caretakerService.persist(ion);

    daniel.addAnimal(new Animal("Parrot"));
    daniel.addAnimal(new Animal("Lizard"));
    caretakerService.persist(daniel);
  }
}