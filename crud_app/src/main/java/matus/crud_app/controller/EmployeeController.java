package matus.crud_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import matus.crud_app.entity.Employee;
import matus.crud_app.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
  private final EmployeeService es;
  private final String mn = "employees";

  public EmployeeController(EmployeeService es) {
    this.es = es;
  }

  @GetMapping
  public String listEmployees(Model m) {
    m.addAttribute(mn, es.findAll());
    return "employees/list";
  }

  @GetMapping("/{id}")
  public String viewEmployee(@PathVariable Integer id, Model m) {
    m.addAttribute(mn, es.findById(id));
    return "employees/view";
  }

  @GetMapping("/create")
  public String showCreateForm(Model m) {
    m.addAttribute(mn, new Employee());
    return "employees/form";
  }

  @PostMapping
  public String createEmployee(@ModelAttribute(mn) Employee e) {
    e.setId(null);
    es.save(e);
    return "redirect:/employee";
  }

  @PostMapping("/{id}/delete")
  public String deleteEmployee(@PathVariable Integer id) {
    es.deleteById(id);
    return "redirect:/employee";
  }

  @GetMapping("/{id}/edit")
  public String showUpdateForm(@PathVariable Integer id, Model m) {
    m.addAttribute(mn, es.findById(id));
    return "employees/form";
  }

  @PostMapping("/{id}")
  public String updateEmployee(@PathVariable Integer id, @ModelAttribute(mn) Employee e) {
    es.findById(id);
    e.setId(id);
    es.save(e);
    return "redirect:/employee";
  }

}