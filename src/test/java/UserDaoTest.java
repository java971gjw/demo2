import bean.FenYe;
import bean.User;
import dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoTest {
    InputStream resourceAsStream=null;
    SqlSession sqlSession=null;
    UserDao mapper=null;
    @Before
    public void before() throws IOException {
        //（1）读取核心配置文件
         resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //（2）创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //（3）使用SqlSessionFactoryBuilder创建SqlSessionFactory
        SqlSessionFactory factory=builder.build(resourceAsStream);
        //（4）使用SqlSessionFactory创建SqlSession
         sqlSession = factory.openSession(true);

        //（5）使用SqlSession创建dao接口的代理对象
         mapper = sqlSession.getMapper(UserDao.class);

    }
    @After
    public void after() throws IOException {

        sqlSession.close();
        resourceAsStream.close();
    }
    @Test
    public void findAllUser() throws IOException {

        //（6）使用代理对象执行方法
        List<User> allUser = mapper.findAllUser();
        System.out.println(allUser);


    }
    @Test
    public void addUser(){
        User user=new User();
        user.setUsername("高亮");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("沙雕一号大厦");
        mapper.addUser(user);

    }
    @Test
    public void xiuGai() throws IOException {
        //（6）使用代理对象执行方法
        User user=new User();
        user.setId(51);
        user.setUsername("lan洋洋");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setAddress("小马");
        mapper.xiuGai(user);
    }
    @Test
    public void delete() throws IOException {
        //（6）使用代理对象执行方法
        int qq=56;
        mapper.delete(qq);
    }
    @Test
    public void chaXun() throws IOException {
        //（6）使用代理对象执行方法
        int qq=51;
        User user = mapper.chaXun(qq);
        System.out.println(user);
    }
    @Test
    public void chaXun1() throws IOException {
        //（6）使用代理对象执行方法

        List<User> user1 = mapper.chaXun1("%王%");
        System.out.println(user1);
    }
    @Test
    public void zongTiaoShu() throws IOException {
        //（6）使用代理对象执行方法

        int i = mapper.zongTiaoShu();
        System.out.println(i);
    }
    @Test
    public void fyChaXun() {
        //（6）使用代理对象执行方法
        FenYe fenYe=new FenYe();
        fenYe.setKaishi(0);
        fenYe.setTiaoshu(5);
        List<User> users = mapper.fyChaXun(fenYe);
        System.out.println(users);
    }
}
