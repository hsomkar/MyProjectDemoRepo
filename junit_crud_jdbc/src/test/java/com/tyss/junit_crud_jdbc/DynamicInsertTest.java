package com.tyss.junit_crud_jdbc;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DynamicInsertTest {

	@Test
	void testInsert() throws SQLException {
		DynamicInsert di = new DynamicInsert();
		int id = 3;
		String name = "omkar";
		double sal = 15000.35;
		Object[] expected = { id, name, sal };
		Object[] actual = di.insert(id, name, sal);
		assertArrayEquals(expected, actual, "To insert values into db");
	}
}
