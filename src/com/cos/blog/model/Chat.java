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
public class Chat {
	private int id;
	private int userid;
	private int pid;
	private String content;
	private Timestamp createDate;
}

