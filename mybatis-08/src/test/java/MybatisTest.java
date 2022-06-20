import com.lin.dao.BlogMapper;
import com.lin.dao.UserMapper;
import com.lin.pojo.Blog;
import com.lin.pojo.User;
import com.lin.utils.IDUtils;
import com.lin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class MybatisTest {
    @Test
    public void getUserListTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> blogList = mapper.getBlogList();
        for (Blog blog:blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void addBlogTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("id", IDUtils.getUUID());
        map.put("title","the girls");
        map.put("author","zhizhi");
        map.put("createTime",new Date());
        map.put("views",20);
        int i = mapper.addBlog(map);
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }
    @Test
    public void getUserListIfTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("title","the girls");
        map.put("author","zhizhi");
        List<Blog> blogList = mapper.getBlogListIf(map);
        for (Blog blog:blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void getUserListChooseTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("id","1");
        map.put("title","the girls");
        map.put("author","zhizhi");
        List<Blog> blogList = mapper.getBlogListChoose(map);
        for (Blog blog:blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void updateTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("oldId","1");
//        map.put("newId","1");
        map.put("title","girls");
        int i = mapper.updateBlogSet(map);
        System.out.println(i);
        sqlSession.close();
    }
    @Test
    public void getBlogForEachTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> map = new HashMap<>();
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        ids.add("3");
        ids.add("4");
        map.put("ids",ids);
        List<Blog> blogList = mapper.getBlogForEach(map);
        for (Blog blog: blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
