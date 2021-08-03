package com.andremapa.RegisterSystem.Controller;

import com.andremapa.RegisterSystem.DTO.Request.UserDTORequest;
import com.andremapa.RegisterSystem.DTO.Response.UserDTOResponse;
import com.andremapa.RegisterSystem.Models.User;
import com.andremapa.RegisterSystem.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    private final Date date = new  Date(2001, 12, 26);
    private final User userTest = new User("Andrew", "123456", "052.396.181-27",
            "andreomapa01@gmail.com", date, "38 9 9923-9772", "Rua 1", "400",
            "Neighborhood 1", "City 1", "MG","38.603-092");

    @Test
    public void shouldCreateMockMVC(){
        assertNotNull(mockMvc);
    }

    @Test
    public void shouldReturnOk_WhenGetUser() throws Exception{
        Date date = new  Date(2001, 12, 26);
        when(this.userService.getUser("052.396.181-27")).thenReturn(userTest);

        this.mockMvc
                .perform(get("/api/v1/main/user/{cpf}", "052.396.181-27"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Andrew"))
                .andExpect(jsonPath("$.password").value("123456"))
                .andExpect(jsonPath("$.cpf").value("052.396.181-27"))
                .andExpect(jsonPath("$.email").value("andreomapa01@gmail.com"))
                .andExpect(jsonPath("$.phoneNumber").value("38 9 9923-9772"))
                .andExpect(jsonPath("$.street").value("Rua 1"))
                .andExpect(jsonPath("$.houseNumber").value("400"))
                .andExpect(jsonPath("$.neighborhood").value("Neighborhood 1"))
                .andExpect(jsonPath("$.city").value("City 1"))
                .andExpect(jsonPath("$.state").value("MG"))
                .andExpect(jsonPath("$.cep").value("38.603-092"));
    }

    @Test
    public void shouldReturnNotFound_WhenGetUserThatNotExists() throws Exception{
        when(this.userService.getUser("111.111.111-11")).thenReturn(null);

        this.mockMvc
                .perform(get("/api/v1/main/user/{cpf}", "111.111.111-11"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnOk_WhenGetAListOfUsers() throws Exception {
        Date date = new  Date(2001, 12, 26);
        when(this.userService.getAllUsers()).thenReturn(List.of(userTest));

        this.mockMvc
                .perform(get("/api/v1/main/users"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnCreated_WhenPostUser() throws Exception{

        Date date = new  Date(2000, 8, 16);
        when(userService.postUser(any(UserDTORequest.class))).thenReturn(new UserDTOResponse(userTest));

        this.mockMvc
                .perform(post("/api/v1/main")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Andrew\", \"password\" : \"123456\", \"cpf\" : \"052.396.181-27\", \"email\": \"andre@gmail.com\", " +
                                "\"birthDate\": \"2001-12-26T00:00:00.000+00:00\", \"phoneNumber\": \"38 9 9923-9772\", " +
                                "\"street\": \"Rua um\", \"houseNumber\": \"152\", \"neighborhood\": \"2\", \"city\": \"3\", " +
                                "\"state\": \"4\", \"cep\": \"38.603-092\"}"))
                .andExpect(status().isCreated());
        verify(userService).postUser(any(UserDTORequest.class));
    }

    @Test
    public void shouldReturnBadRequest_WhenPostUserCpfHasRegister() throws Exception {

        this.mockMvc
                .perform(post("/api/v1/main")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Andrew\", \"password\" : \"123456\", \"cpf\" : \"052.396.181-27\", \"email\": \"andre@gmail.com\", " +
                                "\"birthDate\": \"2001-12-26T00:00:00.000+00:00\", \"phoneNumber\": \"38 9 9923-9772\", " +
                                "\"street\": \"Rua um\", \"houseNumber\": \"152\", \"neighborhood\": \"2\", \"city\": \"3\", " +
                                "\"state\": \"4\", \"cep\": \"38.603-092\"}"))
                .andExpect(status().isBadRequest());
        verify(userService).postUser(any(UserDTORequest.class));
    }
}
