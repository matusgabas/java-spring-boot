package sk.ukf.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class MojController {

  private NotificationService myService;
  private NotificationService myService2;
  private NotificationService myService3;

  @Autowired
  public MojController(@Qualifier("emailNotification") NotificationService myService,
      @Qualifier("smsNotification") NotificationService myService2,
      @Qualifier("pushNotification") NotificationService myService3) {
    this.myService = myService;
    this.myService2 = myService2;
    this.myService3 = myService3;
  }

  @GetMapping("notify/email")
  public String sendNotification() {
    return myService.send("Používateľ sa prihlásil.");
  }

  @GetMapping("notify/sms")
  public String sendNotification2() {
    return myService2.send("Používateľ sa prihlásil.");
  }

  @GetMapping("notify/push")
  public String sendNotification3() {
    return myService3.send("Používateľ sa prihlásil.");
  }

  @GetMapping("/")
  public String hello() {
    int a = 10;
    int c = 250;
    return "Hello world!" + (a + c);
  }

}
