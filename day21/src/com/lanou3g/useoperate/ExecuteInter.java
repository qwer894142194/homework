package com.lanou3g.useoperate;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface ExecuteInter {
    Statement execute(Connection coon) throws SQLException;

}
