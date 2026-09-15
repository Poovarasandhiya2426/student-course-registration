package com.student.courseregistration.controller;

import com.student.courseregistration.constant.StudentConstants;
import com.student.courseregistration.request.StudentRequest;
import com.student.courseregistration.response.ApiResponse;
import com.student.courseregistration.response.StudentResponse;
import com.student.courseregistration.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    // ==========================================
    // REGISTER STUDENT
    // ==========================================

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<StudentResponse>> registerStudent(
            @Valid @RequestBody StudentRequest request) {

        StudentResponse studentResponse =
                studentService.registerStudent(request);

        ApiResponse<StudentResponse> response =
                ApiResponse.<StudentResponse>builder()
                        .success(true)
                        .message(StudentConstants.STUDENT_REGISTERED)
                        .data(studentResponse)
                        .build();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


    // ==========================================
    // GET ALL STUDENTS
    // ==========================================

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentResponse>>> getAllStudents() {

        List<StudentResponse> students =
                studentService.getAllStudents();

        ApiResponse<List<StudentResponse>> response =
                ApiResponse.<List<StudentResponse>>builder()
                        .success(true)
                        .message(StudentConstants.STUDENTS_RETRIEVED)
                        .data(students)
                        .build();

        return ResponseEntity.ok(response);
    }


    // ==========================================
    // GET STUDENT BY ID
    // ==========================================

    @GetMapping("/{studentId}")
    public ResponseEntity<ApiResponse<StudentResponse>> getStudentById(
            @PathVariable Long studentId) {

        StudentResponse studentResponse =
                studentService.getStudentById(studentId);

        ApiResponse<StudentResponse> response =
                ApiResponse.<StudentResponse>builder()
                        .success(true)
                        .message(StudentConstants.STUDENT_RETRIEVED)
                        .data(studentResponse)
                        .build();

        return ResponseEntity.ok(response);
    }


    // ==========================================
    // DELETE STUDENT
    // ==========================================

    @DeleteMapping("/{studentId}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(
            @PathVariable Long studentId) {

        studentService.deleteStudent(studentId);

        ApiResponse<Void> response =
                ApiResponse.<Void>builder()
                        .success(true)
                        .message(StudentConstants.STUDENT_DELETED)
                        .data(null)
                        .build();

        return ResponseEntity.ok(response);
    }
}