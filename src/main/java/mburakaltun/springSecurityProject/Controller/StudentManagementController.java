package mburakaltun.springSecurityProject.Controller;

import mburakaltun.springSecurityProject.Model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Burak Altun"),
            new Student(2, "Begum Altun")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMIN_TRAINEE')")
    List<Student> getStudents() {
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student.toString());
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, Student student) {
        System.out.println(studentId + " " + student.toString());
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println(studentId);
    }
}
