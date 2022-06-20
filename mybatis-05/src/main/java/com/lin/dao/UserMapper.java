package com.lin.dao;


import com.lin.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    // 查询全部用户
    @Select("select * from user")
    List<User> getUserList();

    // 方法存在多个参数，所有的参数前加上@Param，#{token}的token为@Param("token")
    @Select("select * from user where id = #{id} and pwd = #{pwd}")
    List<User> getUserListById(@Param("id") int id,@Param("pwd") String pwd);

    @Insert("insert into user values (#{id},#{name},#{pwd})")
    int addUser(User user);

    @Update("update user set id = 5 where id = #{id}")
    int updateUser(int id);

    @Delete("delete from user where id = ${id} and pwd = ${pwd}")
    int deleteUser(@Param("id") int id,@Param("pwd") String pwd);

}
