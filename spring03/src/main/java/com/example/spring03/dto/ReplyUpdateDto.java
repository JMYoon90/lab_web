package com.example.spring03.dto;

import com.example.spring03.domain.Reply;

import lombok.Data;

@Data
public class ReplyUpdateDto {
	
	private Integer replyId;
	private String replyText; // getReplyText(), setRepltText()
	
	public Reply toEntity() {
		return Reply.builder()
				.id(replyId).replyText(replyText)
				.build();
	}
	

}
