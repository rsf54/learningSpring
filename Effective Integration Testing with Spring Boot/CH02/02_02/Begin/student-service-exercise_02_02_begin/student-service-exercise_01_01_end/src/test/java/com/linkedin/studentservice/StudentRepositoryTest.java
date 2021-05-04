package com.linkedin.studentservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.BDDAssertions.then;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void get_student_by_name_returns_student_details(){
    Student savedStudent = studentRepository.save(new Student(null, "Mark",true,1));
    Student student = studentRepository.getStudentByName("Mark");

    then(student.getId()).isNotNull();
    then(student.getName()).isEqualTo(savedStudent.getName());
    }

    @Test
    void student_grades_in_valid_range_are_valid(){
        Student studentA = studentRepository.save(new Student(null, "Mark", true, 100));
        Integer studentAGrade = studentA.getGrade();
        Student studentB = studentRepository.save(new Student(null, "Abby", true, 0));
        Integer studentBGrade = studentB.getGrade();
        Student studentC = studentRepository.save(new Student(null, "Jack", true, -1));
        Integer studentCGrade = studentC.getGrade();
        Student studentD = studentRepository.save(new Student(null, "Phil", true, 101));
        Integer studentDGrade = studentD.getGrade();

        then(studentAGrade).isLessThanOrEqualTo(100).isGreaterThanOrEqualTo(0);
        then(studentBGrade).isLessThanOrEqualTo(100).isGreaterThanOrEqualTo(0);
        then(studentCGrade).isLessThan(0).isGreaterThan(100);
        then(studentDGrade).isLessThan(0).isGreaterThan(100);
    }
}
