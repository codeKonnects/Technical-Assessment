package io.davidabejirin.assessment;

import io.davidabejirin.assessment.models.Clazz;
import io.davidabejirin.assessment.models.School;
import io.davidabejirin.assessment.models.Student;
import io.davidabejirin.assessment.models.Subject;
import io.davidabejirin.assessment.repository.SchoolClassRepository;
import io.davidabejirin.assessment.repository.SchoolRepository;
import io.davidabejirin.assessment.repository.StudentRepository;
import io.davidabejirin.assessment.repository.SubjectRepository;
import io.davidabejirin.assessment.verticles.AllRouters;
import io.vertx.core.Vertx;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class AssessmentApplication implements CommandLineRunner {
    private final  SchoolRepository schoolRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    private final AllRouters allRouters;

    public static void main(String[] args) {
        SpringApplication.run(AssessmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        School school = new School();
        schoolRepository.save(school);


        Clazz A1 = new Clazz("A1");
        Clazz A2 = new Clazz("A2");
        Clazz B1 = new Clazz("B1");
        Clazz B2 = new Clazz("B2");




        List<String> studentNamesInA1 = List.of("David", "John", "Peter", "Paul", "Mary", "Jane", "Alice", "Bob", "Chris", "Dennis");
        List<String> studentNamesInA2 = List.of("Sam", "Sandra", "Samantha", "Sandy", "Sara", "Sarah", "Sasha", "Savannah", "Scarlett", "Selena");
        List<String> studentNamesInB1 = List.of("Tina", "Tiffany", "Tina", "Toni", "Tori", "Tracy", "Tricia", "Trina", "Trish", "Trisha");
        List<String> studentNamesInB2 = List.of("Uma", "Ursula", "Urszula", "Uta", "Ute", "Utopia", "Uttara", "Uttara", "Uttara", "Uttara");



        // seed class
        createClasses(List.of(A1, A2, B1, B2), school);
        List<Clazz> clazzes = schoolClassRepository.findAll();
        createSubjects(List.of("Maths", "English", "Science", "Social Studies"));
        createStudents(studentNamesInA1, clazzes.get(0));
        createStudents(studentNamesInA2, clazzes.get(1));
        createStudents(studentNamesInB1, clazzes.get(2));
        createStudents(studentNamesInB2, clazzes.get(3));

    }

    public void createStudents(List<String> studentNames, Clazz clazz){
        List<Student> students = studentNames.stream().map(studentName -> {
            Student student = new Student();
            student.setName(studentName);
            student.setSubject(getSubjects(clazz.getName()));
            student.setClazz(clazz);
            return student;
        }).toList();
       studentRepository.saveAll(students);
    }
    public void createClasses(List<Clazz> classNames, School school){
        schoolClassRepository.saveAll(classNames);
    }
    public void createSubjects(List<String> subjectNames){
        for (String subjectName : subjectNames) {
            Subject subject = new Subject();
            subject.setName(subjectName);
            subjectRepository.saveAndFlush(subject);
        }
    }
    private List<Subject> getSubjects(String className){
        List<Subject> subjectList = new ArrayList<>();
        if (className.equalsIgnoreCase("A1") || className.equalsIgnoreCase("A2")){
                subjectList = subjectRepository.findAll(PageRequest.of(0,4)).getContent();
        }
        if (className.equalsIgnoreCase("B1") || className.equalsIgnoreCase("B2")){
            subjectList = subjectRepository.findAll(PageRequest.of(0,6)).getContent();
        }
        return subjectList;
    }
    @PostConstruct
    public void deployVerticles(){
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(allRouters);

    }
}
