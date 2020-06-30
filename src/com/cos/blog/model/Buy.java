package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Buy {
	private int id;
	private int userid;
	private int productid;
	private String buyaddress;
	private String buyrequest;
	private String buypayment;
	private int buyprice;
}
