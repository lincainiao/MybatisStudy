package com.lin.dao;

import com.lin.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();
    // 根据id查询用户
    List<User> getUserListById(int id);
    // 增加用户
    int addUser(User user);
    // 修改
    int updateUser(User user);
    // 删除
    int deleteUser(int id);

    // 利用map传参数
    int addUser2(Map<String,Object> map);

    //
    List<User> getUserById2(Map<String,Object> map);

    List<User> getUserLike(Map<String,Object> map);

}
