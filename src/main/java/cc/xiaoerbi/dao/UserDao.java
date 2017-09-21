package cc.xiaoerbi.dao;

import cc.xiaoerbi.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from user where name = #{name}")
    User findUserByName(@Param("name") String name);
}
