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
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class FourthSentenceControllerTest {
    private PoemService poemService;
    private FourthSentenceController controller;
    private MockHttpServletRequest mockHttpServletRequest;
    private ModelMap modelMap;

    @BeforeMethod
    public void setUp() throws Exception {
        initMocks(this);
        poemService = mock(PoemService.class);
        controller = new FourthSentenceController(poemService);
        mockHttpServletRequest = new MockHttpServletRequest();
        modelMap = mock(ModelMap.class);



    }

    @Test
    public void testOnPage() throws Exception {

        mockHttpServletRequest.getSession().setAttribute("poem", mock(Poem.class));
        String modelAndView = controller.onPage(modelMap, mockHttpServletRequest);

        assertThat(modelAndView).isEqualTo("fourth");
    }

    @Test
    public void testAddSentence() throws Exception {

        BindingResult result = mock(BindingResult.class);
        String modelAndView = controller.addSentence(new Poem("third"),result,mockHttpServletRequest);
        assertThat(modelAndView).isEqualTo("redirect:/home/final");
    }
}
