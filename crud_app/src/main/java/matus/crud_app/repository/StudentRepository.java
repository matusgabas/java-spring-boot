package matus.crud_app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import matus.crud_app.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
  // findAll, findById, save, saveAll, deleteById, delete

  List<Student> findByFirstNameAndLastName(String fn, String ln);

  List<Student> findAllByOrderByLastNameAsc();

  Optional<Student> findByEmail(String email);

  boolean existsByEmail(String email);
}
