package lombok.synchonized;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Action {

    @Synchronized
    @RequestMapping(value = "/demo", method = {RequestMethod.POST, RequestMethod.GET})
    public String calculate(
            @RequestParam String user,
            @RequestParam int a,
            @RequestParam int b
    ) {
        try {
            log.info("Sleeping..");
            Thread.sleep(10000);
            int result = a + b;
            log.info(String.format("user: %s, calculate %d + %d = %d", user, a, b, result));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return "";
        }
    }
}
