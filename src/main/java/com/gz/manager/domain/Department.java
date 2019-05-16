package com.gz.manager.domain;

import javax.persistence.*;

@Entity public class Department {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer department_id;

	/*部门名称*/
	@Column private String name;
}
