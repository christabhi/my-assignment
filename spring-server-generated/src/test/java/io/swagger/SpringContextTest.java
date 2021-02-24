package io.swagger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {Swagger2SpringBoot.class})
public class SpringContextTest {

	private static final Logger log = LoggerFactory.getLogger(SpringContextTest.class);
	
	@Test
    public void contextLoads() {
		log.info("Initialise Spring context for test");
    }
}
