package com.nevermind.jse7.jdbc;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.Predicate;

public class FilterByName implements Predicate {

	@Override
	public boolean evaluate(RowSet rs) {
		try {
			if(rs.getRow() < 1 || rs.isAfterLast()){
				return false;
			}
			if(rs.getString("email").contains("@gmail.com")){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		return false;
	}

	@Override
	public boolean evaluate(Object value, String columnName)
			throws SQLException {
		return true;
	}

}
