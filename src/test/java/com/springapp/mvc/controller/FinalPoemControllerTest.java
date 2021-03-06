package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Poem;
import com.springapp.mvc.service.PoemService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/8/13
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class FinalPoemControllerTest {
    private PoemService poemService;
    private FinalPoemController controller;
    private MockHttpServletRequest mockHttpServletRequest;
    private ModelMap modelMap;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        poemService = mock(PoemService.class);
        controller = new FinalPoemController(poemService);
        mockHttpServletRequest = new MockHttpServletRequest();
        modelMap = mock(ModelMap.class);


    }

    @Test
    public void testOnPage() throws Exception {

        mockHttpServletRequest.getSession().setAttribute("poem", mock(Poem.class));
        String modelAndView = controller.onPage(modelMap, mockHttpServletRequest);

        assertThat(modelAndView).isEqualTo("final");
    }

    @Test
    public void testAddSentence() throws Exception {
        String modelAndView = controller.finalPage(mockHttpServletRequest);
        assertThat(modelAndView).isEqualTo("redirect:/");
    }
}
