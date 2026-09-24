package sk.ukf.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class MojController {

  @GetMapping("/")
  public String hello() {
    return "Hello world!";
  }

}
