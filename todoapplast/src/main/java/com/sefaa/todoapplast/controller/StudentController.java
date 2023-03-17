package com.sefaa.todoapplast.controller;

import com.sefaa.todoapplast.model.Student;
import com.sefaa.todoapplast.model.Todo;
import com.sefaa.todoapplast.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;




    @PostMapping(path="/add-student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return  new ResponseEntity<>(studentService.saveStudent(student), CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @PostMapping("/admin/edit/student/id/{id}")
    public void updateStudent(@PathVariable int id,@RequestBody Student newStudent) {

        studentService.updateStudent(id,newStudent);

    }

    @PostMapping("/admin/edit/student/{id}/list/id/{listId}")
    public void  updateStudentList( @PathVariable int id,@PathVariable int listId,@RequestBody Todo todo)
    {
        studentService.updateTodoList(id,listId,todo);
    }



    @GetMapping("/{id}")
    private Optional<Student> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteStudent(@PathVariable  int id){
        studentService.deleteStudent(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}