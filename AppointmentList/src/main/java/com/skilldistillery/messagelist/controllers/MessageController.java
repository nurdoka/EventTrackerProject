package com.skilldistillery.messagelist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.messagelist.entities.Message;
import com.skilldistillery.messagelist.services.MessageService;

@RestController
@RequestMapping("api")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping("messages")
	public List<Message> showAllMessages(){
		return messageService.getAllMessages();
	}
}
