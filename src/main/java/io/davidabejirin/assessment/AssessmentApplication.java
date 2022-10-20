package io.davidabejirin.assessment;

import io.davidabejirin.assessment.models.School;
import io.davidabejirin.assessment.models.SchoolClass;
import io.davidabejirin.assessment.models.Student;
import io.davidabejirin.assessment.repository.SchoolClassRepository;
import io.davidabejirin.assessment.repository.SchoolRepository;
import io.davidabejirin.assessment.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class AssessmentApplication implements CommandLineRunner {


    private final  SchoolRepository schoolRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(AssessmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        School school = new School();
        schoolRepository.save(school);


        SchoolClass A1 = new SchoolClass("A1");
        A1.setSchool(school);
        SchoolClass A2 = new SchoolClass("A2");
        A2.setSchool(school);
        SchoolClass B1 = new SchoolClass("B1");
        B1.setSchool(school);
        SchoolClass B2 = new SchoolClass("B2");
        B2.setSchool(school);

   //createClasses(List.of(A1, A2, B1, B2), school);
        schoolClassRepository.saveAllAndFlush(List.of(A1, A2, B1, B2));
        List<String> studentNamesInA1 = List.of("David", "John", "Peter", "Paul", "Mary", "Jane", "Alice", "Bob", "Chris", "Dennis");
        List<String> studentNamesInA2 = List.of("Sam", "Sandra", "Samantha", "Sandy", "Sara", "Sarah", "Sasha", "Savannah", "Scarlett", "Selena");
        List<String> studentNamesInB1 = List.of("Tina", "Tiffany", "Tina", "Toni", "Tori", "Tracy", "Tricia", "Trina", "Trish", "Trisha");
        List<String> studentNamesInB2 = List.of("Uma", "Ursula", "Urszula", "Uta", "Ute", "Utopia", "Uttara", "Uttara", "Uttara", "Uttara");


        createStudents(studentNamesInA1, A1);
        createStudents(studentNamesInA2, A2);
        createStudents(studentNamesInB1, B1);
        createStudents(studentNamesInB2, B2);




    }

    public void createStudents(List<String> studentNames, SchoolClass schoolClass){
        for (String studentName : studentNames) {
            Student student = new Student();
            student.setName(studentName);
            student.setSchoolClass(schoolClass);
            studentRepository.saveAndFlush(student);
        }
    }
    public void createClasses(List<SchoolClass> classNames, School school){
        for (SchoolClass className : classNames) {
            SchoolClass schoolClass = new SchoolClass();
            schoolClass.setName(className.getName());
            schoolClass.setSchool(school);
            schoolClassRepository.saveAndFlush(schoolClass);
        }
    }
}
