package com.skilldistillery.appointmentlist.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.appointmentlist.entities.Message;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import net.bytebuddy.matcher.ElementMatcher;

class MessageTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Message message;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAMessageList");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		message = em.find(Message.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		message = null;
	}

	@Test
	void test_Message_entity_mapping() {
		assertNotNull(message);
		assertEquals("Hello", message.getContent());
	}

}
