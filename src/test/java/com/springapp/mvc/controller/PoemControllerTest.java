package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Poem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/5/13
 * Time: 10:05 AM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml",
        "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class PoemControllerTest {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private PoemController poemController;
    @Before
    public void setUp() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac).build();

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();

    }

    @Test
    public void testHome() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/pages/home.jsp"));


    }

    @Test
    public void testFirstSentence() throws Exception {

        mockMvc.perform(post("/home").param("first", "first"))
                .andExpect(status().isOk())
                .andExpect(redirectedUrl("/home/second"));
    }

    @Test
    public void testSecondOnPage() throws Exception {

        Poem poem = new Poem(asList("first"));
        mockMvc.perform(get("/home/second").sessionAttr("poem",poem))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("sentences"));
    }

    @Test
    public void testSecondSentence() throws Exception {

    }

    @Test
    public void testThirdOnPage() throws Exception {

    }

    @Test
    public void testThirdSentence() throws Exception {

    }

    @Test
    public void testFourthOnPage() throws Exception {

    }

    @Test
    public void testFourthSentence() throws Exception {

    }

    @Test
    public void testFinalOnPage() throws Exception {

    }

    @Test
    public void testFinalPage() throws Exception {

    }

    @Test
    public void testInitTheNewPoem() throws Exception {


    }

    @Test
    public void testAddSentencesToModel() throws Exception {

    }

    @Test
    public void testAddSentenceToCurrentPoem() throws Exception {

    }


}
