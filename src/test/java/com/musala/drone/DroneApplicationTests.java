package com.musala.drone;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musala.drone.domain.request.CreateDroneRequest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class DroneApplicationTests {
    protected MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createDroneSuccessfully() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        CreateDroneRequest request = new CreateDroneRequest();
        request.setModel("LIGHTWEIGHT");
        request.setBatteryCapacity(100);
        request.setWeight(Double.parseDouble("20"));
        request.setSerialNumber("1234567899");



        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/api/v1/dispatch")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(request))).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        Assert.assertEquals(content, "Drone successfully created");
    }
}
