package com.cos.blog.dto;

import com.cos.blog.model.Buy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyResponseDto {
	private Buy buy;
	private String pprofile;
	private String ptitle;
	
}
