package com.cos.blog.dto;

import com.cos.blog.model.Basket;

import lombok.Builder;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasketResponseDto {
	private Basket basket;
	private String ptitle;
	private String pcategory;
	private String pplace;
	private int pprice;
	private String pprofile;
}
