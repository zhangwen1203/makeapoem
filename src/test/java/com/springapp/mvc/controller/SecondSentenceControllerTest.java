package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Poem;
import com.springapp.mvc.service.PoemService;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
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
public class SecondSentenceControllerTest {

    private PoemService poemService;
    private SecondSentenceController controller;
    private MockHttpServletRequest mockHttpServletRequest;
    private ModelMap modelMap;

    @BeforeMethod
    public void setUp() throws Exception {
        initMocks(this);
        poemService = mock(PoemService.class);
        controller = new SecondSentenceController(poemService);
        mockHttpServletRequest = new MockHttpServletRequest();
        modelMap = mock(ModelMap.class);


    }

    @Test
    public void testOnPage() throws Exception {

        mockHttpServletRequest.getSession().setAttribute("poem", mock(Poem.class));
        String modelAndView = controller.onPage(modelMap, mockHttpServletRequest);

        assertThat(modelAndView).isEqualTo("second");
    }

    @Test
    public void testAddSentence() throws Exception {
        String modelAndView = controller.addSentence(mockHttpServletRequest);
        assertThat(modelAndView).isEqualTo("redirect:/home/third");
    }
}
