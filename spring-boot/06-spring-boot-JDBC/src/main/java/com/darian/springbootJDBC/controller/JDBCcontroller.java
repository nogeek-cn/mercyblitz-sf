package com.darian.springbootJDBC.controller;

import com.darian.springbootJDBC.domain.User;
import com.darian.springbootJDBC.service.UserSevice;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import lombok.Cleanup;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class JDBCcontroller {

    private final DataSource dataSource;
    private final UserSevice userSevice;
    private final JdbcTemplate jdbcTemplate;

    @GetMapping("jdbc/meta/transaction/supported")
    public Boolean supportedTransaction() {
        Boolean supported = false;
        try {
            Connection connection = dataSource.getConnection();
            DatabaseMetaData metaData = connection.getMetaData();
            supported = metaData.supportsTransactions();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return supported;
    }

    @GetMapping("/users")
    public List<Map<String, Object>> getUsers() {
        return jdbcTemplate.execute((StatementCallback<List<Map<String, Object>>>) statement -> {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user;");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            List<String> columnNames = new ArrayList<>(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                columnNames.add(columnName);
            }

            List<Map<String, Object>> data = new LinkedList<>();

            while (resultSet.next()) {
                Map<String, Object> columnData = new LinkedHashMap<>();
                for (String columnName : columnNames) {
                    Object columnValue = resultSet.getObject(columnName);
                    columnData.put(columnName, columnValue);
                }
                data.add(columnData);
            }
            return data;
        });
    }

    @GetMapping("/user/get")
    public Map<String, Object> getUser(
            @RequestParam(value = "id", defaultValue = "1") String id) {

        Map<String, Object> data = new HashMap<>();
//        Savepoint savepoint = null;
        try {
            @Cleanup Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
//            savepoint = connection.setSavepoint();
            PreparedStatement statement = connection
                    .prepareStatement("SELECT id, username, password FROM user WHERE id =?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idreturn = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                data.put("id", idreturn);
                data.put("username", username);
                data.put("password", password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            try {
//                connection.rollback(savepoint);
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
        } finally {
        }
        return data;
    }

    @PostMapping("/user/add")
    public Map<String, Object> getDataSource(@RequestBody User user) {
        Map<String, Object> data = new HashMap<>();
        data.put("success", userSevice.save(user));
        return data;
    }
}
