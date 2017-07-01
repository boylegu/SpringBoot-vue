package com.boylegu.springboot_vue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.boylegu.springboot_vue.controller.MainController;

/**
 * @author Boyle Gu
 * @version 0.0.1
 * @GitHub https://github.com/boylegu
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class SpringbootVueApplicationTests {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(
                new MainController()).build();
    }

    @Test
    public void testUserController() throws Exception {
//  	Test MainController
        RequestBuilder request = null;

        request = get("/api/persons/sex");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        request = get("/api/persons/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        request = get("/api/persons/detail/1");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"username\":\"test\",\"zone\":20}]")));

        request = put("/api/persons/detail/1")
                .param("phone", "111111")
                .param("email", "test@qq.com");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        request = get("/api/persons");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }

}
