package com.student.courseregistration.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    @NotBlank(message = "Student name cannot be empty")
    private String studentName;

    @NotBlank(message = "Course name cannot be empty")
    private String courseName;

    @Email(message = "Enter valid email")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @Min(value = 18, message = "Age must be above 18")
    private Integer age;
}