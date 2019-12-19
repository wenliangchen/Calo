package run.calo.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import run.calo.app.service.BlogService;

@Controller
public class ArchiveShowController {


    @Autowired
    private BlogService blogService;

    @GetMapping("/archive")
    public String archives(Model model)
    {
        model.addAttribute("archiveMap",blogService.archiveBlog());
        model.addAttribute("blogCount",blogService.countBlog());
        return "archive";
    }
}
