package com.student.courseregistration.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StudentConstants {

    // ==========================================
    // SUCCESS MESSAGES
    // ==========================================

    public static final String STUDENT_REGISTERED =
            "Student registered successfully";

    public static final String STUDENTS_RETRIEVED =
            "Students retrieved successfully";

    public static final String STUDENT_RETRIEVED =
            "Student retrieved successfully";

    public static final String STUDENT_DELETED =
            "Student registration deleted successfully";


    // ==========================================
    // ERROR MESSAGES
    // ==========================================

    public static final String STUDENT_NOT_FOUND =
            "Student not found";

    public static final String DUPLICATE_STUDENT =
            "Student is already registered for this course";

    public static final String VALIDATION_FAILED =
            "Validation failed";

    public static final String INTERNAL_SERVER_ERROR =
            "Internal server error";

    public static final String INVALID_REQUEST =
            "Invalid request";
}