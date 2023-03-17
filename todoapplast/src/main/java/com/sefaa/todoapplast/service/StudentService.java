package com.sefaa.todoapplast.service;

import com.sefaa.todoapplast.model.Student;
import com.sefaa.todoapplast.model.Todo;
import com.sefaa.todoapplast.repository.StudentRepository;
import com.sefaa.todoapplast.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final TodoRepository todoRepository;

    public Student saveStudent(Student student) {


        Student student1 = new Student();


        student1.setId(student.getId());
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setPassword(student.getPassword());
        student1.setStudentId(student.getStudentId());
        student1.setTodo(student.getTodo());

        final Student studentDb = studentRepository.save(student1);


        return studentDb;


    }

    public List<Student> getAll() {
        List<Student> students = studentRepository.findAll();
        List<Student> students1 = new ArrayList<>();

        students.forEach(it -> {
            Student student = new Student();
            student.setId(it.getId());
            student.setStudentId(it.getStudentId());
            student.setPassword(it.getPassword());
            student.setName(it.getName());
            student.setEmail(it.getEmail());
            student.setTodo(it.getTodo());

            students1.add(student);
        });
        return students1;
    }

    public Optional<Student> getStudentById(int id) {


        return studentRepository.findById(id);

    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);

    }

    public void createProgramForStudent(int id, Student newStudent) {

        Student student = studentRepository.findById(id).get();
        List<Todo> newTodos = student.getTodo();
       newTodos.addAll(newStudent.getTodo());
        student.setTodo(newTodos);

        studentRepository.save(student);


    }

    public static <T> void merge(T source, T target) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(source, target);
    }

    public void updateStudent(int id, Student newStudent) {

        Student student = studentRepository.findById(id).get();

        merge(newStudent, student);

        studentRepository.save(student);

    }


    public void updateTodoList(int id, int listId, Todo todoList) {

        Student student = studentRepository.findById(id).get();

        Todo todo = todoRepository.findById(listId).get();

        if (student.getTodo().contains(todo)) {

            merge(todoList, todo);


        }


    }
}
