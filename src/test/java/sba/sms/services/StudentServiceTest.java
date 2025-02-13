package sba.sms.services;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sba.sms.models.Student;
import sba.sms.utils.CommandLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


class StudentServiceTest {
   private StudentService StudentService;

   @BeforeEach
   void setUp() {
       StudentService = new StudentService();
   }

@Test
    void createStudent() {
    Student student = new Student("test@test.com", "test", "test");
    StudentService.createStudent(student);
    Student retrievedStudent = StudentService.getStudentByEmail("test@test.com");
assertNotNull(retrievedStudent);
   assertEquals(student.getEmail(), StudentService.getStudentByEmail("test@test.com").getEmail());
   assertEquals(student.getName(), StudentService.getStudentByEmail("test@test.com").getName());

}

}