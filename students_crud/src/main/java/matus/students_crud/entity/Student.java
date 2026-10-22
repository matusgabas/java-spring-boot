package matus.students_crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @NotBlank(message = "Meno je povinné")
  @Size(min = 2, max = 50, message = "Meno musí mať 2-50 znakov")
  @Column(name = "first_name", nullable = false, length = 50)
  private String firstName;

  @NotBlank(message = "Priezvisko je povinné")
  @Size(min = 2, max = 50, message = "Priezvisko musí mať 2-50 znakov")
  @Column(name = "last_name", nullable = false, length = 50)
  private String lastName;

  @NotBlank(message = "Email je povinný")
  @Email(message = "Neplatný email")
  @Size(max = 100, message = "Email môže mať najviac 100 znakov")
  @Column(name = "email")
  private String email;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
