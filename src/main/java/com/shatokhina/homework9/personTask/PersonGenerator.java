package com.shatokhina.homework9.personTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PersonGenerator {
    List<Person> generate(int quantity) {
        if (quantity <= 0) return Collections.emptyList();

        ThreadLocalRandom random = ThreadLocalRandom.current();
        int numberOfNames = Name.values().length;
        int numberOfCompany = Company.values().length;

        List<Person> people = new ArrayList<>(quantity);

        for (int i = 0; i < quantity; i++) {
            people.add(
                    new Person(
                            Name.getName(random.nextInt(numberOfNames)),
                            random.nextInt(20, 70),
                            random.nextInt(10, 15),
                            Company.getCompany(random.nextInt(numberOfCompany))
                    )
            );
        }

        return people;
    }
}