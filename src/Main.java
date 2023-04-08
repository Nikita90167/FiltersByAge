import java.util.*;

public class Main {
    public static Long filterByAge (Collection<Person> people, int ageFrom) {
        return people.stream()
                .filter(person -> person.getAge() >= ageFrom)
                .count();
    }
    public static Collection<String> ageFilterForConscripts (Collection<Person> people, int ageFrom, int ageTo) {
       return people.stream()
                .filter(person -> person.getSex().equals(Sex.MAN))
                .filter(person -> person.getAge() >= 18 && person.getAge() < 28)
                .map(person -> String.valueOf(person.getFamily()))
                .toList();
    }
    public static Collection<String> workablePerson (Collection<Person> people, int ageFrom, int ageToMan, int ageToWoman) {
        return people.stream()
                .filter(person -> person.getSex() == Sex.MAN ? person.getAge() > ageFrom && person.getAge() < ageToMan + 1 : person.getAge() > ageFrom && person.getAge() < ageToWoman + 1)
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .map(person -> String.valueOf(person.getFamily()))
                .sorted(Comparator.naturalOrder())
                .toList();
    }
    public static void main(String[] args) {
       List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
       List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
       Collection<Person> persons = new ArrayList<>();
       for (int i = 0; i < 10_000_000; i++) {
           persons.add(new Person(
                   names.get(new Random().nextInt(names.size())),
                   families.get(new Random().nextInt(families.size())),
                   new Random().nextInt(100),
                   Sex.values()[new Random().nextInt(Sex.values().length)],
                   Education.values()[new Random().nextInt(Education.values().length)]));
        }

    }
}