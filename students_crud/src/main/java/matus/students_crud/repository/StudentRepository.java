package matus.students_crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import matus.students_crud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
  // findAll, findById, save, saveAll, deleteById, delete

  List<Student> findByFirstNameAndLastName(String fn, String ln);

  List<Student> findAllByOrderByLastNameAsc();
}
