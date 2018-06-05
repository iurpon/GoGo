package ru.firstproject.web;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

public class RootControllerTest  extends AbstractControllerTest{

    @Test
    public void root() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/index.jsp"));

    }

    @Test
    public void users() throws Exception {
    }

    @Test
    public void adminJob() throws Exception {
    }

    @Test
    public void getVote() throws Exception {
    }

    @Test
    public void setUser() throws Exception {
    }

    @Test
    public void checkVote() throws Exception {
    }

    @Test
    public void checkVote1() throws Exception {
    }

    @Test
    public void newOrUpdate() throws Exception {
    }

    @Test
    public void addMenu() throws Exception {
    }

    @Test
    public void addMenu1() throws Exception {
    }

}