package dao;

import bean.FenYe;
import bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    @Select("select * from user")
    List<User> findAllUser();
    @Insert("insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address}) ")
    void addUser(User user);
    @Update(" update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    void xiuGai(User user);
    @Delete(" delete from user where id=#{id}")
    void delete(int id);
    @Select(" select * from user where id=#{ui}")
    User chaXun(int id);
    @Select("select * from user where username like #{name}")
    List<User> chaXun1(String s);
    @Select("select count(*) from user")
    int zongTiaoShu();
    @Select(" select * from user limit #{kaishi},#{tiaoshu}")
    List<User> fyChaXun(FenYe fenYe);
}
