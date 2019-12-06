package run.calo.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
@RestController
public class GetIdController {
    private static final String template ="Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/getid")
    public getid GetId(@RequestParam(value="name", defaultValue="sbddd") String name) {
        return new getid(counter.incrementAndGet(),
                String.format(template, name));
    }
}
