package com.lanou3g.database;

import com.lanou3g.userdao.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface ExecuteInter {
    Statement execute(Connection conn, User u) throws SQLException;
}
