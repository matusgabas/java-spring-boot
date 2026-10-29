package matus.crud_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import matus.crud_app.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class StudentController {
  @Value("${countries}")
  private List<String> countries;

  @GetMapping("/")
  public String index() {
    return "redirect:/zobraz-formular";
  }

  @GetMapping("/zobraz-formular")
  public String zobrazFormular(Model m) {
    Student s = new Student();
    m.addAttribute("student", s);
    m.addAttribute("countries", countries);

    return "student-form";
  }

  @PostMapping("/spracuj-formular")
  public String spracujFormular(@ModelAttribute("student") Student s) {
    return "student-confirmation";
  }

}
