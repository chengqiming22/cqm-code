package com.cqm;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cqm.controller.HomeController;

/**
 * Created by qmcheng on 2017/10/19 0019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeControllerTest {

  private MockMvc mvc;

  @Before
  public void setup() {
    mvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
  }

  @Test
  public void hello() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(equalTo("hello world")));
  }
}
