package com.wan.service.Impl;

import com.wan.entity.Blog;
import com.wan.service.BlogService;

/**
 * @author wan
 * @Description:
 * @date 2022/11/30 15:06
 */
public class BlogServiceImpl implements BlogService {
    @Override
    public Blog getBlogById(Integer id) {
        Blog blog = Blog.builder().id(id).title("我的博客").useId(22).build();
        System.out.println("客户端查询了"+id+"博客");
        return blog;
    }
}
