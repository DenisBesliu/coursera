package sort.comparator;

import java.util.Arrays;

import help.Student;

/**
 * @author dbesliu
 * @created 4/2/13
 */
public class Main {

    public static void main(String[] args) {
        final Student denis = createStudent("Denis", 25, "Causeni");
        final Student andrei = createStudent("Andrei", 27, "Cahul");
        final Student alex = createStudent("Alex", 26, "Cantemir");
        final Student vitalie = createStudent("Vitalie", 28, "Chisinau");
        final Student alexandr = createStudent("Alexandr", 24, "Edinet");
        final Student stas = createStudent("Stas", 23, "Causeni");
        final Student alina = createStudent("Alina", 29, "Soroca");

        Student[] students = new Student[] { denis, andrei, alex, vitalie, alexandr, stas, alina };
        Arrays.sort(students, Student.BY_NAME);
        printStudents(students);
        Arrays.sort(students, Student.BY_AGE);
        printStudents(students);
        Arrays.sort(students, Student.BY_SCHOOL);
        printStudents(students);
    }


    private static void printStudents(final Student[] aStudents) {
        System.out.println();
        for (Student student : aStudents) {
            System.out.print(" " + student.getName());
        }
    }


    private static Student createStudent(final String aName, final int aAge, final String aSchool) {
        return new Student(aName, aAge, aSchool);
    }

}
