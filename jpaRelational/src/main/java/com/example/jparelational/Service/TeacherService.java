package com.example.jparelational.Service;

import com.example.jparelational.Api.ApiException;
import com.example.jparelational.Model.Teacher;
import com.example.jparelational.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher updatedTeacher) {
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null)
            throw new ApiException("Teacher not found");

        teacher.setName(updatedTeacher.getName());
        teacher.setAge(updatedTeacher.getAge());
        teacher.setEmail(updatedTeacher.getEmail());
        teacher.setSalary(updatedTeacher.getSalary());

        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null)
            throw new ApiException("Teacher not found");

        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherById(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null)
            throw new ApiException("Teacher not found");

        return teacher;
    }
}
