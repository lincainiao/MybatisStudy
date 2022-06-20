// Mybatis缓存

import com.lin.mapper.BlogMapper;
import com.lin.mapper.UserMapper;
import com.lin.pojo.Blog;
import com.lin.pojo.User;
import com.lin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void getBlogTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user: userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    // 测试一级缓存
    @Test
    public void getBlogByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserListById(2);
        for (User user: userList) {
            System.out.println(user);
        }
        List<User> userList2 = mapper.getUserListById(2);
        for (User user : userList2) {
            System.out.println(user);
        }
        System.out.println(userList.hashCode() == userList2.hashCode());
        sqlSession.close();
    }
    // 在两次相同的查询中插入新的操作，导致一级缓存失效
    @Test
    public void cacheTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map = new HashMap<>();
        map.put("id",2);

        List<User> userList = mapper.getUserListById(1);
        for (User user: userList) {
            System.out.println(user);
        }

        int i = mapper.updateUser(map);

        List<User> userList2 = mapper.getUserListById(1);
        for (User user : userList2) {
            System.out.println(user);
        }
        System.out.println(userList.hashCode() == userList2.hashCode());

        sqlSession.close();
    }
    // 手动清楚缓存
    @Test
    public void cacheTest2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map = new HashMap<>();
        map.put("id",222);

        List<User> userList = mapper.getUserListById(1);
        for (User user: userList) {
            System.out.println(user);
        }

        sqlSession.clearCache();

        List<User> userList2 = mapper.getUserListById(1);
        for (User user : userList2) {
            System.out.println(user);
        }
        System.out.println(userList.hashCode() == userList2.hashCode());

        sqlSession.close();
    }

    // 二级缓存
    @Test
    public void cacheTest3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);


        List<User> userList = mapper.getUserListById(1);
        for (User user: userList) {
            System.out.println(user);
        }
        // 第一个会话关闭之后，将一级缓存保存到二级缓存中
        sqlSession.close();

        List<User> userList2 = mapper2.getUserListById(1);
        for (User user : userList2) {
            System.out.println(user);
        }
        System.out.println(userList.hashCode() == userList2.hashCode());

        sqlSession2.close();
    }
}
