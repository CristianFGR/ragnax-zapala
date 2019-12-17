package com.ragnax.ragnaxzapala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.ragnax.zapala.RagnaxZapalaApplication;
import com.ragnax.zapala.controller.ZapalaController;
import com.ragnax.zapala.controller.modelo.Zapala;
import com.ragnax.zapala.controller.modelo.ZapalaRequest;
import com.ragnax.zapala.servicio.Chapala;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RagnaxZapalaApplication.class)
@WebMvcTest(controllers = ZapalaController.class)
class RagnaxZapalaApplicationTests {
	
	@Autowired
	 private MockMvc mockMvc;
	
	@MockBean
    private Chapala chapala;
	
	@Test
	public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
	  throws Exception {
	    
		String prueba = "alex";
	    ZapalaRequest zapalaRequest = new ZapalaRequest();
	    
	    zapalaRequest.setPrueba(prueba);
	    
	    Zapala zapala = new  Zapala(zapalaRequest.getLocalDateTime().getSecond()+
				""+zapalaRequest.getLocalDateTime().getNano());
	    
	    mockMvc.perform(post("/api/employees")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	}

}
