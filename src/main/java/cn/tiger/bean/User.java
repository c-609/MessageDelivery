package cn.tiger.bean;

import lombok.Data;

import java.util.List;

@Data
public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer status;
	
	private List<Role> roles;
	private List<Dept> depts;
	private List<Groups> groups;
	private Student student;
	private Teacher teacher;
	
}
