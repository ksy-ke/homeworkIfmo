package com.shatokhina.homework9.personTask;

import java.util.Comparator;
import java.util.List;

public class Person {
    private final Name name;
    private final int age;
    private final int salary;
    private final Company company;

    public Person(Name name, int age, int salary, Company company) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                ", salary=" + salary +
                ", company=" + company +
                '}';
    }

    static Comparator<Person> sortByName = Comparator.comparing((Person person) -> String.valueOf(person.name));
    static Comparator<Person> sortByNameSalary = sortByName.thenComparingInt(person -> person.salary);
    static Comparator<Person> sortByAll = sortByNameSalary.thenComparingInt(person -> person.age)
            .thenComparing(person -> person.company);

    public static void main(String[] args) {
        PersonGenerator generator = new PersonGenerator();
        List<Person> people = generator.generate(20);
        people.forEach(System.out::println);

        System.out.println("By name: ");
        people.sort(sortByName);
        people.forEach(System.out::println);

        System.out.println("By name and salary: ");
        people.sort(sortByNameSalary);
        people.forEach(System.out::println);

        System.out.println("By all: ");
        people.sort(sortByAll);
        people.forEach(System.out::println);
    }
}