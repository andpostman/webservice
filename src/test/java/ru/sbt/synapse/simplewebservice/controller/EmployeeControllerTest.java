package ru.sbt.synapse.simplewebservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.sbt.synapse.simplewebservice.property.Employee;
import ru.sbt.synapse.simplewebservice.service.EmployeeServiceImpl;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@DisplayName("Операции контроллера с events")
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeServiceImpl service;

    @Test
    @DisplayName("Проверка получения пользователей")
    void whenGet_thenReturns200() throws Exception {
        mockMvc.perform(get("/api/v1/employees"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Проверка создания пользователя object")
    void whenSendBodyAsObject_thenReturns200() throws Exception{
        Employee employee = new Employee("Gor","Zerov","re@ya.ru");
        mockMvc.perform(post("/api/v1/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Проверка создания пользователя curl")
    void whenSendValuesAsCurlBody_thenReturns200() throws Exception {
        mockMvc.perform(post("/api/v1/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"Artur\",\"secondName\":\"Gorov\",\"emailId\":\"ss@ya.ru\"}"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Проверка получения пользователей по id")
    void whenIdExist_thenReturns200() throws Exception {
        mockMvc.perform(get("/api/v1/employees/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Проверка обновления пользователя")
    void whenUpdate_thenReturns200() throws Exception{
        Employee employee = new Employee("Gorets","Goretska","rsss@ya.ru");
        mockMvc.perform(put("/api/v1/employees/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Проверка обновления пользователя")
    void whenDelete_thenReturns200() throws Exception{
        Employee employee = new Employee("Gorets","Goretska","rsss@ya.ru");
        mockMvc.perform(delete("/api/v1/employees/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }
}
