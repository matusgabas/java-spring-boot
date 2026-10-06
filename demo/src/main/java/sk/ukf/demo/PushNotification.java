package sk.ukf.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sk.ukf.demo.format.MessageFormatter;

@Component("pushNotification")
public class PushNotification implements NotificationService {

  private final MessageFormatter mf;

  public PushNotification(@Qualifier("upperCase") MessageFormatter mf) {
    this.mf = mf;
  }

  @Override
  public String send(String message) {
    return "Posielam push správu: " + mf.format(message);
  }
}
