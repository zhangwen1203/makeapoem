package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Poem;
import com.springapp.mvc.service.PoemService;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/8/13
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class FirstSentenceControllerTest {
    private PoemService poemService;
    private FirstSentenceController controller;
    private MockHttpServletRequest mockHttpServletRequest;
    private ModelMap modelMap;


    @BeforeMethod
    public void setUp() throws Exception {
        initMocks(this);
        poemService = mock(PoemService.class);
        controller = new FirstSentenceController(poemService);
        mockHttpServletRequest = new MockHttpServletRequest();
        modelMap = mock(ModelMap.class);
    }

    @Test
    public void testOnPage() throws Exception {
        String modelAndView = controller.onPage(modelMap);

        assertThat(modelAndView).isEqualTo("home");

    }

    @Test
    public void testAddSentence() throws Exception {
        BindingResult result = mock(BindingResult.class);
        String modelAndView = controller.addSentence(new Poem("first"),result,mockHttpServletRequest);
        assertThat(modelAndView).isEqualTo("redirect:/home/second");
    }
}
