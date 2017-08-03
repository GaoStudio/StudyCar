package cn.stucar.test;

import cn.stucar.dao.UserDao;
import cn.stucar.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Reader;

/**
 * Created by Administrator on 2017/8/3.
 */
public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static{
        try{
            reader    = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = (User) session.selectOne("cn.stucar.dao.UserDao.selectUserByID", 1);
            System.out.println(user.getUser_name());
            System.out.println(user.getUser_phone());
        } finally {
            session.close();
        }
    }
    ApplicationContext ctx=null;
    @Before
    public void TestBefore(){
        ctx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
    }
    @org.junit.Test
    public void SpringMyBatis(){
        UserDao userDao=(UserDao) ctx.getBean("userDao");
        User user = userDao.selectUserByID(1);
        System.out.println(user.getUser_name());
        System.out.println(user.getUser_phone());
    }
    @org.junit.Test
    public void LogTest() throws Exception {

        Logger logger = Logger.getLogger(Test.class);

        //使用默认的配置信息，不需要写log4j.properties
        BasicConfigurator.configure();
        //设置日志输出级别为info，这将覆盖配置文件中设置的级别
        logger.setLevel(Level.ERROR);
        //下面的消息将被输出
        logger.info("this is an info");
        logger.warn("this is a warn");
        logger.error("this is an error");
        logger.fatal("this is a fatal");
    }

}
