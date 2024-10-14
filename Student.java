import java.util.ArrayList;
import java.util.Date;

public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private Date  dateOfBirth;
    private ArrayList<Integer> grades;

    public Student(int studentId, String firstName, String lastName, Date dateOfBirth, ArrayList<Integer> grades) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.grades = grades;
    }

    public Student(int studentId, String firstName, String lastName, Date dateOfBirth) {
        this(studentId, firstName, lastName, dateOfBirth, new ArrayList<>());
    }


    public double calculateGradeAverage() {
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public boolean isExcellent() {
        return calculateGradeAverage()   >= 28;
    }
}

public class Professor {
    private int id;
    private String firstName;
    private String lastName;
    private String courseTaught;

    public Professor(int id, String firstName, String lastName, String courseTaught) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseTaught = courseTaught;
    }

    public Professor(int id, String firstName, String lastName) {
        this(id, firstName, lastName, "");
    }


    public void assignGrade(Student s, int grade) {
        if (grade >= 18) {
            s.getGrades().add(grade);
        } else {
            System.out.println("Student " + s.getFirstName() + " " + s.getLastName() + " has failed the course.");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student(1, "Alice", "Smith", new Date(), new ArrayList<>());
        Student student2 = new Student(2, "Bob", "Johnson", new Date(), new ArrayList<>());
        Student student3 = new Student(3, "Charlie", "Brown", new Date(), new ArrayList<>());
        Student student4 = new Student(4, "David", "Lee", new Date(), new ArrayList<>());


        Professor professor1 = new Professor(101, "John", "Doe", "Math");
        Professor professor2 = new Professor(102, "Jane", "Smith", "Science");

        professor1.assignGrade(student1, 25);
        professor1.assignGrade(student2, 30);
        professor2.assignGrade(student3, 20);
        professor2.assignGrade(student4, 15);

        Student[] students = {student1, student2, student3, student4};
        Professor[] professors = {professor1, professor2};

        System.out.println("Excellent students:");
        for (Student student : students) {
            if (student.isExcellent()) {
                System.out.println(student.getFirstName()  + " " + student.getLastName());
            }
        }
        
        Student highestGradeStudent = null;
        double highestGradeAverage = 0;
        for (Student student : students) {
            double average = student.calculateGradeAverage();
            if (average > highestGradeAverage) {
                highestGradeStudent = student;
                highestGradeAverage = average;
            }
        }
        System.out.println("Student with highest grade average:");
        System.out.println(highestGradeStudent.getFirstName() + " " + highestGradeStudent.getLastName());
    }
}