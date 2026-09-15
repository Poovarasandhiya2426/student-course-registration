package com.student.courseregistration.serviceImpl;

import com.student.courseregistration.constant.StudentConstants;
import com.student.courseregistration.exception.DuplicateStudentException;
import com.student.courseregistration.exception.StudentNotFoundException;
import com.student.courseregistration.model.Student;
import com.student.courseregistration.request.StudentRequest;
import com.student.courseregistration.response.StudentResponse;
import com.student.courseregistration.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentServiceImpl implements StudentService {

    private final List<Student> students = new ArrayList<>();

    private final AtomicLong studentIdGenerator = new AtomicLong(0);


    // ==========================================
    // REGISTER STUDENT
    // ==========================================

    @Override
    public StudentResponse registerStudent(StudentRequest request) {

        boolean duplicateRegistration = students.stream()
                .anyMatch(student ->
                        student.getEmail().equalsIgnoreCase(request.getEmail())
                                && student.getCourseName()
                                .equalsIgnoreCase(request.getCourseName())
                );

        if (duplicateRegistration) {

            throw new DuplicateStudentException(
                    StudentConstants.DUPLICATE_STUDENT
            );
        }

        Student student = Student.builder()
                .studentId(studentIdGenerator.incrementAndGet())
                .studentName(request.getStudentName())
                .courseName(request.getCourseName())
                .email(request.getEmail())
                .age(request.getAge())
                .build();

        students.add(student);

        return mapToResponse(student);
    }


    // ==========================================
    // GET ALL STUDENTS
    // ==========================================

    @Override
    public List<StudentResponse> getAllStudents() {

        return students.stream()
                .map(this::mapToResponse)
                .toList();
    }


    // ==========================================
    // GET STUDENT BY ID
    // ==========================================

    @Override
    public StudentResponse getStudentById(Long studentId) {

        Student student = findStudentById(studentId);

        return mapToResponse(student);
    }


    // ==========================================
    // DELETE STUDENT REGISTRATION
    // ==========================================

    @Override
    public void deleteStudent(Long studentId) {

        Student student = findStudentById(studentId);

        students.remove(student);
    }


    // ==========================================
    // FIND STUDENT BY ID
    // ==========================================

    private Student findStudentById(Long studentId) {

        return students.stream()
                .filter(student ->
                        student.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                StudentConstants.STUDENT_NOT_FOUND
                        )
                );
    }


    // ==========================================
    // MODEL → RESPONSE MAPPING
    // ==========================================

    private StudentResponse mapToResponse(Student student) {

        return StudentResponse.builder()
                .studentId(student.getStudentId())
                .studentName(student.getStudentName())
                .courseName(student.getCourseName())
                .email(student.getEmail())
                .age(student.getAge())
                .build();
    }
}