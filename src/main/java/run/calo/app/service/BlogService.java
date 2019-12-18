package run.calo.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import run.calo.app.po.Blog;
import run.calo.app.vo.BlogQuery;

import java.util.List;
import java.util.Optional;


public interface BlogService {
    Optional<Blog> getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable,BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId,Pageable pageable);

    Page<Blog> listBlog(String query,Pageable pageable);

    List<Blog> listRecommendBlogTop(Integer size);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);

}
