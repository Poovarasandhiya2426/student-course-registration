package com.student.courseregistration.service;

import com.student.courseregistration.request.StudentRequest;
import com.student.courseregistration.response.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse registerStudent(StudentRequest request);

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Long studentId);

    void deleteStudent(Long studentId);
}