package com.chatbuddy.chat_application.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
	private MsgType type;
	private String content;
	private String sender;
	public Object getSender;
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
