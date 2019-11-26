package com.darian.springbootJDBC.domain;

import com.darian.springbootJDBC.service.UserSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserSevice {
    private final JdbcTemplate jdbcTemplate;
    private final PlatformTransactionManager platformTransactionManager;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE,rollbackFor = {Exception.class})
    @Override
    public boolean save(User user) {
        Boolean result = jdbcTemplate.execute(
                "INSERT INTO user( username, password) VALUES (?, ?)",
                (CallableStatementCallback<Boolean>) preparedStatement -> {
                    preparedStatement.setString(1, user.getUsername());
                    preparedStatement.setString(2, user.getPassword());
                    return preparedStatement.executeUpdate() > 0;
                });
        return result;
    }

    public boolean save2(User user){
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(defaultTransactionDefinition);
        save(user);
        platformTransactionManager.commit(transactionStatus);
        return true;
    }
}
