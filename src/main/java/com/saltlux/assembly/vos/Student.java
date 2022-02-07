package com.saltlux.assembly.vos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.Data;

@Alias("student")
@Entity
@Table(name = "student")
@Data
@Builder
public class Student {

	@Id
	private int num;
	private String name;
}
