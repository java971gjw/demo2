package dao;

import bean.FenYe;
import bean.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoleDao {
    @Select("select * from role")
    List<Role> chaXun();
    @Select(" select * from role where id=#{ui}")
    Role idChaXun(int id);
    @Select("select * from role where role_name like #{name}")
    List<Role>moHuChaXun(String name);
    @Insert("insert into role(id,role_name,role_desc) values(#{id},#{role_name},#{role_desc}) ")
    void tianJia(Role role);
    @Update(" update role set role_name=#{role_name},role_desc=#{role_desc} where id=#{id}")
    void xiuGai(Role role);
   @Delete("<script>"+
           "        delete from role\n" +
           "        <where>\n" +
           "            <foreach collection=\"list\" item=\"id\" separator=\",\" open=\"id IN(\" close=\")\">\n" +
           "                #{id}\n" +
           "            </foreach>\n" +
           "        </where>\n" +
           "</script>")
    void delete(List<Integer> list);
    @Select(" select * from role limit #{kaishi},#{tiaoshu}")
    List<Role>fenYe(FenYe fenYe);
    @Select("<script>"+
            "  select * from role\n" +
            "        <where>\n" +
            "            <if test=\"role_name!=null and role_name.length()>0\">\n" +
            "                role_name like #{role_name}\n" +
            "            </if>\n" +
            "            <if test=\"role_desc!=null and role_desc.length()>0\">\n" +
            "                and role_desc like #{role_desc}\n" +
            "            </if>\n" +
            "        </where>"+
            "</script>")
    List<Role> fuZaChaXun(Role role);
}
