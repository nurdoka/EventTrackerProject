package com.skilldistillery.messagelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.messagelist.entities.Message;

public interface MessageRepository  extends JpaRepository<Message, Integer>{

}
