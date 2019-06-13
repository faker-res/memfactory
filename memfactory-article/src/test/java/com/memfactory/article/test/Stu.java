/**
 * 
 */
package com.memfactory.article.test;

import java.math.BigDecimal;

/**
 * @author zhairp
 * @date 2018年8月23日
 * @since 0.0.1
 */
public class Stu {
	private Long no;
	private String name;
	private Integer age;
	private BigDecimal score;

	public Stu(Long no, String name, Integer age) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
	}

	public Stu(Long no, String name, Integer age, BigDecimal score) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Stu [no=" + no + ", name=" + name + ", age=" + age + ", score=" + score + "]";
	}

}
