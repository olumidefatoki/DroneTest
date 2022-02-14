package com.musala.drone;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musala.drone.controller.DispatchController;
import com.musala.drone.domain.request.CreateDroneRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DroneControllerTest {
    private MockMvc mvc;

    @Autowired
    DispatchController controller;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }


    @Test
    public void createDroneSuccessfully() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CreateDroneRequest request = new CreateDroneRequest();
        request.setModel("LIGHTWEIGHT");
        request.setBatteryCapacity(100);
        request.setWeight(Double.parseDouble("20"));
        request.setSerialNumber("1234567890");


        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/api/v1/drone")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(request))).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        Assert.assertTrue(content.contains("Drone successfully created"));
    }
}
