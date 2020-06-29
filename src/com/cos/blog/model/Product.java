package com.cos.blog.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	private int pid;
	private int puserId;
	private String ptitle;
	private String pcategory;
	private String pplace;
	private int pprice;
	private String pcontent;
	private String pprofile;
	private int preadCount;
	private Timestamp pcreateDate;
}
