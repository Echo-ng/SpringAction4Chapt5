package spittr.web;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.bean.Spitter;
import spittr.bean.Spittle;
import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class IndexControllerTest {
//    @Test
//    public void testIndexControllerPage(){
//        IndexController controller = new IndexController();
//        assertEquals("index",controller.index());
//    }

//    @Test
//    public void testIndexPage() throws Exception {
//        IndexController controller = new IndexController();
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/"))
//                .andExpect(MockMvcResultMatchers.view().name("index"));
//    }

//    @Test
//    public void shouldShowRecentSpittles() throws Exception{
//        List<Spittle> expectedSpittles = createSpittleList(20);
//        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
//        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE,20))
//                .thenReturn(expectedSpittles);
//
////        SpittleControl
//    }
//
//    private List<Spittle> createSpittleList(int count) {
//        List<Spittle> spittles = new ArrayList<>();
//        for (int i = 0;i < count;i++){
//            spittles.add(new Spittle("Spittle "+i,new Date()));
//        }
//        return spittles;
//    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> spittles = createSpittleList(50);
        SpittleRepository mockRespository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRespository.findSpittles(238900,50))
                .thenReturn(spittles);
        SpittleController controller = new SpittleController(mockRespository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("WEB-INF/views/spittles.jsp"))
                .build();
        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",hasItems(spittles.toArray())));
    }

//    @Test
//    public void shouldShowRegistration() throws Exception {
//        SpitterController spitterController = new SpitterController();
//        MockMvc mockMvc = standaloneSetup(spitterController).build();
//        mockMvc.perform(get("/spitter/register"))
//                .andExpect(view().name("registerForm"));
//    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        //mock repository
        SpitterRepository mockRepository = Mockito.mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("echostack","echo","zeng","echostack123");
        Spitter saved = new Spitter(null,"echostack","echo","zeng","echostack123");
        Mockito.when(mockRepository.save(unsaved)).thenReturn(saved);
        //mock request
        SpitterController spitterController = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(spitterController).build();

        mockMvc.perform(post("/spitter/register")
                            .param("firstName","echo")
                            .param("lastName","zeng")
                            .param("username","echostack")
                            .param("password","echostack123"))
                .andExpect(redirectedUrl("/spitter/echostack"));

        verify(mockRepository,atLeastOnce()).save(saved);

    }


    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for(int i = 0;i < count;i++){
            Spittle spittle = new Spittle((long)i);
            spittles.add(spittle);
        }
        return spittles;
    }
}