package run.calo.app.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import run.calo.app.po.Blog;
import run.calo.app.po.User;
import run.calo.app.service.BlogService;
import run.calo.app.service.TagService;
import run.calo.app.service.TypeService;
import run.calo.app.vo.BlogQuery;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class BlogController {


    private static final String INPUT = "admin/edit";
    private static final String LIST = "admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";


    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 2, sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model){

        model.addAttribute("types",typeService.listType());
        model.addAttribute("page",blogService.listBlog(pageable,blog));

        return LIST;
    }
    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 2, sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model){
        model.addAttribute("page",blogService.listBlog(pageable,blog));

        return "/admin/blogs ::blogList";
    }

    @GetMapping("/blogs/input")
    public String input(Model model){

        setTypeAndTag(model);
        model.addAttribute("blog",new Blog());
        return "/admin/edit";
    }

    private void setTypeAndTag(Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
    }

    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model){

        setTypeAndTag(model);
        Optional<Blog> blog = blogService.getBlog(id);
        //it is a Bug here
        //should be blog.init();
        blog.get();
        model.addAttribute("blog",blog);

        return "/admin/edit";
    }

    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){

        blog.setUser((User)session.getAttribute("user"));
        //it is a Bug here(Fixed!)
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.listTag(blog.getTagIds()));
        Blog b = blogService.saveBlog(blog);
        if (blog.getId() == null){
            b = blogService.saveBlog(blog);
        }else {
            b= blogService.updateBlog(blog.getId(),blog);
        }

        if(b ==null) {
            attributes.addFlashAttribute("Message","fail");
        }else{
            attributes.addFlashAttribute("Message","Success");
        }


        return REDIRECT_LIST;
    }

    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message","deleted!");
        return REDIRECT_LIST;
    }
}
