//package com.darian.springbootmybatis.demo;
//
//import com.darian.springbootmybatis.entity.User;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.springframework.core.io.DefaultResourceLoader;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.core.io.support.EncodedResource;
//
//
//import java.io.Reader;
//import java.util.Properties;
//
//
//public class MyBatisXmlConfigurationDemo {
//    public static void main(String[] args) throws Exception {
//        ResourceLoader resourceLoader = new DefaultResourceLoader();
//        Resource resource = resourceLoader.getResource("classpath:/mybatis/mybatis-config.xml");
//        // 字符流
//        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
////        InputStream inputStream = resource.getInputStream();
//        Reader reader = encodedResource.getReader();
//
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = builder.build(reader, "dev", new Properties());
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        User user = sqlSession.selectOne("SelectONeUser", 1);
//
//        System.err.println(user.toString());
//        sqlSession.close();
//
////        InputStream inputStream = ClassLoader.getSystemResourceAsStream("mybatis/mybatis-config.xml");
////        Reader reader1 = new InputStreamReader(inputStream, "UTF-8");
////
//    }
//}
