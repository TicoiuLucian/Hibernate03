package org.example;

import org.example.entity.Animal;
import org.example.entity.Caretaker;
import org.example.service.AnimalService;
import org.example.service.CaretakerService;
import org.example.service.Service;

public class Main {
  public static void main(String[] args) {
    Service<Caretaker> caretakerService = new CaretakerService();
    Service<Animal> animalService = new AnimalService();

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

    ion.addAnimal(new Animal("Deer"));
    ion.addAnimal(new Animal("Mouse"));
    animalService.findByName("Tiger");
    ion.addAnimal(tiger);

    daniel.addAnimal(new Animal("Parrot"));
    daniel.addAnimal(new Animal("Lizard"));

    caretakerService.persist(marcel);
    caretakerService.persist(ion);
    caretakerService.persist(daniel);
  }
}