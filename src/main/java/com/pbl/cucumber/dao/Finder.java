package com.pbl.cucumber.dao;

/**
 * Created by Steven Satelle on 06/08/2017.
 */

import com.pbl.cucumber.config.Config;
import org.apache.commons.dbcp2.BasicDataSource;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Function;

@Component
public abstract class Finder {


    private DataSource dataSource;

        private BasicDataSource getDataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/pbl");
        bds.setUsername("root");
        bds.setPassword("marketconadmin");
        bds.setInitialSize(5);
        return bds;
    }

    @Autowired
    protected Finder(DataSource dataSource) {
//        this.dataSource = getDataSource();
        this.dataSource = dataSource;
    }

    protected <T extends Record> Result<T> find(Function<DSLContext, Result<T>> query) {
        try (Connection conn = dataSource.getConnection();
             DSLContext context = DSL.using(conn, SQLDialect.MYSQL)) {
            return query.apply(context);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}