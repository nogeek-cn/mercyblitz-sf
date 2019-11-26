//package com.darian.springbootmybatis.handle;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.ibatis.type.JdbcType;
//import org.apache.ibatis.type.TypeHandler;
//import org.springframework.context.annotation.Description;
//import org.springframework.util.StringUtils;
//
//
//import java.io.IOException;
//import java.io.StringWriter;
//import java.sql.CallableStatement;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class DescriptinTypeHandler implements TypeHandler {
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public void setParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
//        try {
//            StringWriter stringWriter = new StringWriter();
//            objectMapper.writeValue(stringWriter, o);
//            String desc = stringWriter.toString();
//            preparedStatement.setString(i, desc);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Object getResult(ResultSet resultSet, String s) throws SQLException {
//        String desc = resultSet.getString(s);
//        Description description = null;
//
//        try {
//            if (StringUtils.hasText(desc)) {
//                description = objectMapper.readValue(desc, Description.class);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @Override
//    public Object getResult(ResultSet resultSet, int i) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Object getResult(CallableStatement callableStatement, int i) throws SQLException {
//        return null;
//    }
//}
