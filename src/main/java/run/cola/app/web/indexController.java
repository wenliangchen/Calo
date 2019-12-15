package run.cola.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @GetMapping("/")
    public String index(){
//        int i = 9/0;
//        String Blog = null;
//        if (Blog == null){
//            throw new NotFoundException("Can not find page");
//        }
        return "index";
    }
    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
}
