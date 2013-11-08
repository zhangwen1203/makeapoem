package com.springapp.mvc.service;

import com.springapp.mvc.domain.Poem;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/8/13
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class PoemServiceTest {

    private MockHttpServletRequest mockHttpServletRequest;
    private PoemService poemService;

    @BeforeMethod
    public void setUp() throws Exception {
        initMocks(this);
        mockHttpServletRequest = new MockHttpServletRequest();
        poemService = new PoemService();


    }
    @Test
    public void testInitTheNewPoem() throws Exception {

        poemService.initTheNewPoem(mockHttpServletRequest);
        assertThat(mockHttpServletRequest.getSession().getAttribute("poem")).isInstanceOf((new Poem()).getClass());
    }

    @Test
    public void testAddSentencesToModel() throws Exception {

        ModelMap  modelMap = new ModelMap();
        mockHttpServletRequest.getSession().setAttribute("poem",(new Poem(Arrays.asList("1234"))));
        poemService.addSentencesToModel(modelMap, mockHttpServletRequest);
        assertThat(modelMap.containsAttribute("sentences")).isEqualTo(true);
        assertThat(modelMap.get("sentences")).isEqualTo(Arrays.asList("1234"));
    }

    @Test
    public void testAddSentenceToCurrentPoem() throws Exception {

        mockHttpServletRequest = new MockHttpServletRequest();
        String sentence = new String("second");
        mockHttpServletRequest.setParameter(sentence, "second_context");
        mockHttpServletRequest.getSession().setAttribute("poem", new Poem(new ArrayList()));
        poemService.addSentenceToCurrentPoem(mockHttpServletRequest,sentence);

        assertThat(((Poem)mockHttpServletRequest.getSession().getAttribute("poem")).getSentences())
                .isEqualTo(Arrays.asList("second_context"));

    }
}
