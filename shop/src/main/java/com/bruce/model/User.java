package com.bruce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户名模块实体类:
 * 
 * @author 传智.郭嘉 CREATE TABLE `user` ( `uid` int(11) NOT NULL AUTO_INCREMENT,
 *         `username` varchar(255) DEFAULT NULL, `password` varchar(255) DEFAULT
 *         NULL, `name` varchar(255) DEFAULT NULL, `email` varchar(255) DEFAULT
 *         NULL, `phone` varchar(255) DEFAULT NULL, `addr` varchar(255) DEFAULT
 *         NULL, `state` int(11) DEFAULT NULL, `code` varchar(64) DEFAULT NULL,
 *         PRIMARY KEY (`uid`) ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT
 *         CHARSET=utf8;
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer uid;
	@Column
	@NotNull(message = "{username.notnull}")
	@NotEmpty(message = "{username.notnull}")
	private String username;
	@Column
	private String password;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String addr;
	@Column
	private Integer state;
	@Column
	private String code;

}
