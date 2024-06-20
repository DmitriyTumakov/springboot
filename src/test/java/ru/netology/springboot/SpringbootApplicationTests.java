package ru.netology.springboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.TestEnvironment;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringbootApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;

    GenericContainer<?> containerFirst = new GenericContainer<>("devapp").withExposedPorts(8080);
    GenericContainer<?> containerSecond = new GenericContainer<>("prodapp").withExposedPorts(8081);

    @BeforeEach
    void setUp() {
        containerFirst.start();
        containerSecond.start();
    }

    @Test
    void contextLoads() {
        ResponseEntity<String> entityFirst = restTemplate.getForEntity("http://localhost:" +
                containerFirst.getMappedPort(8080) + "/profile", String.class);
        ResponseEntity<String> entitySecond = restTemplate.getForEntity("http://localhost:" +
                containerSecond.getMappedPort(8081) + "/profile", String.class);

        System.out.println(entityFirst.getBody());
        System.out.println(entitySecond.getBody());
    }

}
