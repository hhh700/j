package richardlab21g01project2.test;
import richardlab21g01project2.controllers.ContentController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContentController.class)
public class ContentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testHome() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
                // .andExpect(content().string("User with ID: 123"));
                
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testLogin() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testAdmin() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/admin/home"))
                .andExpect(status().isOk());
    }
}

// @Test
// public void testGetUserById() throws Exception {
//     mockMvc.perform(get("/users/123"))
//             .andExpect(status().isOk())
//             .andExpect(content().string("User with ID: 123"));
// }

// @Test
// public void testHello() throws Exception {
//     mockMvc.perform(get("/users/hello"))
//             .andExpect(status().isOk())
//             .andExpect(content().string("Hello, World!"));
// }
