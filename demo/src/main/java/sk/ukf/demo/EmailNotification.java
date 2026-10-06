package sk.ukf.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sk.ukf.demo.format.MessageFormatter;

@Component("emailNotification") // toto je default ID. použivať iba ak chcem ine
public class EmailNotification implements NotificationService {

  private final MessageFormatter mf;

  public EmailNotification(@Qualifier("html") MessageFormatter mf) {
    this.mf = mf;
  }

  @Override
  public String send(String message) {
    return "Posielam notifikaciu e-mailom: " + mf.format(message);
  }
}
