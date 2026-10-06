package sk.ukf.demo.format;

import org.springframework.stereotype.Component;

@Component("plain")
public class Plain implements MessageFormatter {
  @Override
  public String format(String message) {
    return message;
  }
}
