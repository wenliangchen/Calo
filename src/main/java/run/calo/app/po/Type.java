package run.calo.app.po;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_type")
public class Type {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Type name illegal")

    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> Blogs = new ArrayList<>();

    public Type() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return Blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        Blogs = blogs;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Blogs=" + Blogs +
                '}';
    }
}
