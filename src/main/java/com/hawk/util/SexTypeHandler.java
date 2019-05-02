package com.hawk.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhangdonghao
 * @date 2019/4/16
 */
public class SexTypeHandler extends BaseTypeHandler<Object> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        if (parameter.equals("男")) {
            ps.setString(i, Integer.valueOf(1).toString());
        } else {
            ps.setString(i, Integer.valueOf(0).toString());
        }
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String resultSet = rs.getString(columnName);
        if (resultSet.equals("1")) {
            return "男";
        } else {
            return "女";
        }
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String resultSet = rs.getString(columnIndex);
        if (resultSet.equals("1")) {
            return "男";
        } else {
            return "女";
        }
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String resultSet = cs.getString(columnIndex);
        if (resultSet.equals("1")) {
            return "男";
        } else {
            return "女";
        }
    }
}

