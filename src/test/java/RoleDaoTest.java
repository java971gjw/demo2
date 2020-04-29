


import bean.FenYe;
import bean.Role;
import dao.RoleDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.management.relation.RoleResult;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class RoleDaoTest {
    InputStream resourceAsStream = null;
    SqlSession sqlSession = null;
    RoleDao mapper = null;

    @Before
    public void before() throws IOException {
        //（1）读取核心配置文件123
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //（2）创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //（3）使用SqlSessionFactoryBuilder创建SqlSessionFactory
        SqlSessionFactory factory = builder.build(resourceAsStream);
        //（4）使用SqlSessionFactory创建SqlSession
        sqlSession = factory.openSession();
        //（5）使用SqlSession创建dao接口的代理对象
        mapper = sqlSession.getMapper(RoleDao.class);
    }

    @After
    public void after() throws IOException {
        sqlSession.commit();

        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void ChaXun() {
        List<Role> roles = mapper.chaXun();
        System.out.println(roles);

    }

    @Test
    public void idChaXun() {
        Role role = mapper.idChaXun(2);
        System.out.println(role);
    }

    @Test
    public void moHuCHaXun() {
        List<Role> cc = mapper.moHuChaXun("%长%");
        System.out.println(cc);
    }

    @Test
    public void tianjia() {
        Role role = new Role();
        role.setId(6);
        role.setRole_name("456");
        role.setRole_desc("123");
        mapper.tianJia(role);
    }

    @Test
    public void xiuGai() {
        Role role = new Role();
        role.setId(5);
        role.setRole_name("4566");
        role.setRole_desc("123");
        mapper.xiuGai(role);
    }
    @Test
    public void delete() {
        List<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(6);
        mapper.delete(list);

    }
    @Test
    public void fenYe(){
        FenYe fenYe=new FenYe();
        fenYe.setKaishi(0);
        fenYe.setTiaoshu(2);
        List<Role> roles = mapper.fenYe(fenYe);
        System.out.println(roles);
    }
    @Test
    public void fuZaChaXun(){
        Role role=new Role();
        role.setRole_name("%长%");
        role.setRole_desc("%学%");
        List<Role> roles = mapper.fuZaChaXun(role);
        System.out.println(roles);
    }
}
