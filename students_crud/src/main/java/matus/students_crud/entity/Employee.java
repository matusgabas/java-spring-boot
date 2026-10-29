package matus.students_crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @NotBlank(message = "Meno je povinné")
  @Size(min = 2, max = 30, message = "Meno musí mať 2-30 znakov")
  @Column(name = "first_name", nullable = false, length = 30)
  private String firstName;

  @NotBlank(message = "Priezvisko je povinné")
  @Size(min = 2, max = 30, message = "Priezvisko musí mať 2-30 znakov")
  @Column(name = "last_name", nullable = false, length = 30)
  private String lastName;

  @NotBlank(message = "Dátum narodenia je povinný")
  @Size(min = 10, max = 10, message = "Priezvisko musí mať 2-30 znakov")
  @Column(name = "birth_date", nullable = false, length = 10)
  private String birthDate;

  // @Pattern(regexp = "[a-zA-z0-9]{64}@[a-zA-Z0-9]{255}", message = "Email je
  // povinný")
  @NotBlank(message = "Email je povinný")
  @Pattern(regexp = "^(?:[A-Za-z0-9!#$%&'*+\\-/=?^_`{|}~]+(?:\\.[A-Za-z0-9!#$%&'*+\\-/=?^_`{|}~]+)*|\"[^\"]*\")@(?:[A-Za-z0-9](?:[A-Za-z0-9-]{0,61}[A-Za-z0-9])?\\.)+(?!\\d+$)[A-Za-z0-9](?:[A-Za-z0-9-]{0,61}[A-Za-z0-9])?$", message = "Chyba formátu")
  @Column(name = "email")
  private String email;

  @Pattern(regexp = "^\\+421\\d{9}$", message = "Telefónne číslo musí začínať +421 a obsahovať presne 9 číslic za ním.")
  @Column(name = "phone")
  private String phone;

  @NotBlank(message = "Názov povolania je povinný")
  @Size(min = 2, max = 50, message = "Názov povolania musí mať 2-50 znakov")
  @Column(name = "job_title", nullable = false, length = 50)
  private String jobTitle;

  @Min(value = 0, message = "Plat nemože byť menší ako 0")
  @Column(name = "salary", nullable = false)
  private Double salary;

  @Column(name = "full_time")
  private Boolean fulltime;

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

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public Boolean getFulltime() {
    return fulltime;
  }

  public void setFulltime(Boolean fulltime) {
    this.fulltime = fulltime;
  }

}
