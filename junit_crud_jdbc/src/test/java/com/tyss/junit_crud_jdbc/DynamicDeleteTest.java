package com.tyss.junit_crud_jdbc;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DynamicDeleteTest {

	@Test
	void testDelete() {
		DynamicDelete dd = new DynamicDelete();
		assertThrows(SQLException.class, ()->dd.delete(5), "should throw ");
	}
}
