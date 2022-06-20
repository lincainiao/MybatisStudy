package com.lin.dao;

import com.lin.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    List<Blog> getBlogList();
    // 动态SQL
    List<Blog> getBlogListIf(Map<String,Object> map);

    List<Blog> getBlogListChoose(Map<String,Object> map);
    // 查询id为1,2,3,4的blog
    List<Blog> getBlogForEach(Map<String,Object> map);

    int updateBlogSet(Map<String,Object> map);


    int addBlog(Map<String,Object> map);

}
