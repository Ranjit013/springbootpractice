package org.main.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.main.SpringApplicationTests;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringApplicationTests.class})
public class EmployeeControllerTest {


    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @InjectMocks
    private org.main.controller.EmployeeController employeeController;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void test() throws Exception {
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("id", "1");
        requestParams.add("name", "john");
        requestParams.add("age", "30");
        this.mockMvc.perform(get("/api/test")).andExpect(status().isOk()).andExpect(content().string("Hello World"));
        this.mockMvc.perform(put("/api/puttest/id/1").
                params(requestParams))
                .andExpect(status().isOk())
                .andExpect(content()
                .string(Matchers.isEmptyOrNullString()));
        System.out.println("Test");

    }

}
