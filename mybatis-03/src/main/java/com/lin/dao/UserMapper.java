package com.lin.dao;


import com.lin.pojo.User;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();
    List<User> getUserListById(int id);

    List<User> getUserListLimit(Map<String,Object> map);

    List<User> getUserByRowBounds();

}
