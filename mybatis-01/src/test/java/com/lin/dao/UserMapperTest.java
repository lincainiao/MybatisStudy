package com.lin.dao;

import com.lin.pojo.User;
import com.lin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            // 1、获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            // 2、执行sql
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            for (User user:userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (sqlSession != null)
            sqlSession.close();
        }
    }
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserListById(1);
        for (User user:userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    // 增
    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int wxy = mapper.addUser(new User(4, "wxy", "123456"));
        System.out.println(wxy);

        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    // 改
    @Test
    public void test4(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int zs = mapper.updateUser(new User(1, "zz", "123456"));
        System.out.println(zs);

        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    // 删
    @Test
    public void test5(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int zs = mapper.deleteUser(5);
        System.out.println(zs);

        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map map = new HashMap<String,Object>();
        map.put("userid",5);
        map.put("username","zhao");
        map.put("userpwd","123456");
        int user = mapper.addUser2(map);
        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void getUserById2Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map map = new HashMap<String,Object>();
        map.put("userpwd","123456");
        List<User> userById2 = mapper.getUserById2(map);

        for (User user:userById2) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    // 模糊查询
    @Test
    public void getUserLikeTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("value","%z%");
        List<User> userList = mapper.getUserLike(map);
        for (User user:userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
