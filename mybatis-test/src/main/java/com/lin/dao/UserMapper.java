package com.lin.dao;

import com.lin.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
//    @Select("select * from user limit #{startIndex},#{endIndex}")
    List<User> getUserList(Map<String, Object> map);

    int updateUser(Map<String,Object> map);
}
