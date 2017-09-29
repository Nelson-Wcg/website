package cc.xiaoerbi.dao;

import cc.xiaoerbi.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from user where username = #{name}")
    @Results({@Result(property = "profilePicture", column = "profile_picture")})
    User findUserByName(@Param("name") String name);
}
