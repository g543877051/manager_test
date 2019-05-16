package com.gz.manager.domain;

import javax.persistence.*;

@Entity public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;

	/*用户名称*/
	@Column private String name;

	/*部门id*/
	@Column(name = "department_id") private Integer departmentId;
}
