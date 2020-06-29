package com.cos.blog.dto;

import com.cos.blog.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto {
	private Product product;
	private String username;
}
