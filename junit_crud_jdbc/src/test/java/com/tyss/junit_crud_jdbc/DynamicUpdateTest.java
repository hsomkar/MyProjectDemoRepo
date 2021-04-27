package com.tyss.junit_crud_jdbc;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DynamicUpdateTest {

	@Test
	void testUpdate() throws SQLException {
		DynamicUpdate du = new DynamicUpdate();
		int id = 3;
		String name = "sreepad";
		double sal = 25000.35;
		Object[] expected = { id, name, sal };
		Object[] actual = du.update(id, name, sal);
		assertArrayEquals(expected, actual, "To update values in db");
	}

}
