package de.rieckpil.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(RootController.class)
@TestPropertySource(properties = "welcome.message=Test Property Hello World!")
class RootControllerTestPropertyTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void shouldReturnDefaultWelcomeMessage() throws Exception {
    this.mockMvc
      .perform(MockMvcRequestBuilders.get("/"))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().string("Test Property Hello World!"));
  }
}
