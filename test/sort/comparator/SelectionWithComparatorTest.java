package sort.comparator;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import help.Messages;
import help.NullArrayOrComparatorException;
import help.Student;
import help.Students;

/**
 * @author dbesliu
 * @created 4/2/13
 */
@RunWith(Parameterized.class)
public class SelectionWithComparatorTest {

    Student[] students;


    @Before
    public void setUp() throws Exception {
        final Students[] allStudents = Students.values();
        students = new Student[allStudents.length];
        for (int i = 0; i < allStudents.length; i++) {
            students[i] = allStudents[i].getStudent();
        }
    }


    @Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] { { new SelectionWithComparator() }, { new InsertionWithComparator() },
                                             { new MergeWithComparator() } });
    }

    private final ComparatorSort sort;


    public SelectionWithComparatorTest(final ComparatorSort aSort) {
        sort = aSort;
    }


    @Test(expected = NullArrayOrComparatorException.class)
    public void nullArrayAndComparator() {
        sort.sort(null, null);
    }


    @Test
    public void testStudentsByName() {
        sort.sort(students, Student.BY_NAME);

        assertStudent(Students.ALEX.getStudent(), students[0]);
        assertStudent(Students.ALEXANDR.getStudent(), students[1]);
        assertStudent(Students.ALINA.getStudent(), students[2]);
        assertStudent(Students.ANDREI.getStudent(), students[3]);
        assertStudent(Students.DENIS.getStudent(), students[4]);
        assertStudent(Students.STAS.getStudent(), students[5]);
        assertStudent(Students.VITALIE.getStudent(), students[6]);
    }


    @Test
    public void testStudentsByAge() {
        sort.sort(students, Student.BY_AGE);

        assertStudent(Students.STAS.getStudent(), students[0]);
        assertStudent(Students.ALEXANDR.getStudent(), students[1]);
        assertStudent(Students.DENIS.getStudent(), students[2]);
        assertStudent(Students.ALEX.getStudent(), students[3]);
        assertStudent(Students.ANDREI.getStudent(), students[4]);
        assertStudent(Students.VITALIE.getStudent(), students[5]);
        assertStudent(Students.ALINA.getStudent(), students[6]);
    }


    @Test
    public void testStudentsBySchool() {
        sort.sort(students, Student.BY_SCHOOL);

        assertStudent(Students.ANDREI.getStudent(), students[0]);
        assertStudent(Students.ALEX.getStudent(), students[1]);
        assertStudent(Students.VITALIE.getStudent(), students[4]);
        assertStudent(Students.ALEXANDR.getStudent(), students[5]);
        assertStudent(Students.ALINA.getStudent(), students[6]);
    }


    private void assertStudent(final Student aExpected, final Student aCurrent) {
        final String message = String.format(Messages.WRONG_STUDENT_MESSAGE.toString(), aExpected.getName(), aCurrent.getName());
        assertEquals(message, aExpected, aCurrent);
    }


    private Student createStudent(final String aName, final int aAge, final String aSchool) {
        return new Student(aName, aAge, aSchool);
    }

}
