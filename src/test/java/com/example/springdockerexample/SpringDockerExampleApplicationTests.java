package com.example.springdockerexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


import com.example.springdockerexample.controllers.GroceryItemController;

@SpringBootTest()
class SpringDockerExampleApplicationTests {

	@Autowired
	private GroceryItemController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
