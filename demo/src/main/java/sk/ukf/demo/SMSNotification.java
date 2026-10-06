package sk.ukf.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sk.ukf.demo.format.MessageFormatter;

@Component("smsNotification")
public class SMSNotification implements NotificationService {

  private final MessageFormatter mf;

  public SMSNotification(@Qualifier("plain") MessageFormatter mf) {
    this.mf = mf;
  }

  @Override
  public String send(String message) {
    return "Posielam SMS správu: " + mf.format(message);
  }
}
