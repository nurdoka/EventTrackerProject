package com.skilldistillery.messagelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.messagelist.entities.Message;
import com.skilldistillery.messagelist.repositories.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageRepository messageRepo;

	@Override
	public List<Message> getAllMessages() {
		return messageRepo.findAll();
	}

}
