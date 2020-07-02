package com.cos.blog.dto;

import com.cos.blog.model.Chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatResponseDto {
	Chat chat;
	private String username;
	private String userProfile;	
}
