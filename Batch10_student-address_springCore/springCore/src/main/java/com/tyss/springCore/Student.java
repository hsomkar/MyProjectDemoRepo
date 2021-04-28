package com.tyss.springCore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

	private int stdNo;
	private String name;
	private Address address;

}
