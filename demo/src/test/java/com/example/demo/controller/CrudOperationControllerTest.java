
  package com.example.demo.controller;
  
  
  import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
  
  import org.junit.jupiter.api.Test; import org.mockito.Mockito; 
  import org.springframework.beans.factory.annotation.Autowired; 
  import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; 
  import org.springframework.boot.test.mock.mockito.MockBean; 
  import org.springframework.http.MediaType; 
  import org.springframework.test.web.servlet.MockMvc; 
  import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
  import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
  
  import com.example.demo.entity.Company; import
  com.example.demo.repository.CompanyRepo; import
  com.fasterxml.jackson.databind.ObjectMapper;
  
  @WebMvcTest(CrudOperationController.class) 
  public class CrudOperationControllerTest {
  
  @Autowired MockMvc mockMvc;
  
  @Autowired ObjectMapper mapper;
  
  @MockBean CompanyRepo companyRepo;
  
  @Test public void testInsert() throws Exception { Company comp = new
  Company(); comp.setId(1); comp.setName("Soumya"); comp.setAge(28);
  comp.setAddress("karnataka");
  Mockito.when(companyRepo.save(comp)).thenReturn(comp);
  MockHttpServletRequestBuilder mockRequest =
  MockMvcRequestBuilders.post("/insert")
  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON)
  .content(this.mapper.writeValueAsString(comp)); mockMvc.perform(mockRequest)
  .andExpect(status().isOk());
  
  }
  
  @Test public void testUpdate() throws Exception {
  MockHttpServletRequestBuilder mockRequest =
  MockMvcRequestBuilders.put("/update")
  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON)
  .queryParam("age", "29").queryParam("id", "1");
  
  mockMvc.perform(mockRequest) .andExpect(status().isOk());
  
  }
  
  @Test public void testSelect() throws Exception {
  MockHttpServletRequestBuilder mockRequest =
  MockMvcRequestBuilders.get("/select")
  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
  
  mockMvc.perform(mockRequest) .andExpect(status().isOk());
  
  }
  
  @Test public void testdelete() throws Exception {
  MockHttpServletRequestBuilder mockRequest =
  MockMvcRequestBuilders.delete("/delete")
  .contentType(MediaType.APPLICATION_JSON)
  .accept(MediaType.APPLICATION_JSON).queryParam("id", "1");
  
  mockMvc.perform(mockRequest) .andExpect(status().isOk());
  
  }
  
  }
 