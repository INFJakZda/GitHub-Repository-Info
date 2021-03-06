package github;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getModelInfo() throws Exception {
        mockMvc.perform(get("http://localhost:8080/repositories/infjakzda/Calculator"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.fullName", is("INFJakZda/Calculator")))
                .andExpect(jsonPath("$.description", is("Reverse polish notation calculator - Android.")))
                .andExpect(jsonPath("$.cloneUrl", is("https://github.com/INFJakZda/Calculator.git")))
                .andExpect(jsonPath("$.stars", is(0)))
                .andExpect(jsonPath("$.createdAt", is("2018-04-01T21:59:50Z")));

        mockMvc.perform(get("http://localhost:8080/repositories/infjakzda/Calculators"))
                .andExpect(status().isNotFound());
    }

}