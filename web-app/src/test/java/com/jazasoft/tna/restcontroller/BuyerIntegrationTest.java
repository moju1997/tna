package com.jazasoft.tna.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jazasoft.tna.ApiUrls;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Mojahid Hussain on 14-Jul-17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles(value = "test")
public class BuyerIntegrationTest {

    @Autowired
    MockMvc mvc;

    private ObjectMapper mapper;

    @Before
    public void setUp(){
        mapper = new ObjectMapper();
    }

    @Test
    public void getAllUsers() throws Exception{
        this.mvc.perform(get(ApiUrls.ROOT_URL_BUYERS))
                .andExpect(status().isOk())
                //.andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].name",is("Md Zahid Raza")))
                .andExpect(jsonPath("$[0].links").exists());
    }

}
