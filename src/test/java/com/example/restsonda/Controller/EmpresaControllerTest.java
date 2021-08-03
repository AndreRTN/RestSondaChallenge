package com.example.restsonda.Controller;

import com.example.restsonda.Model.Empresa;
import com.example.restsonda.Repository.EmpresaRepository;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith({SpringExtension.class})
@ActiveProfiles("test")
@WebMvcTest(controllers = EmpresaController.class)
@AutoConfigureMockMvc
public class EmpresaControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    EmpresaRepository empresaRepository;

    @Test
    @DisplayName("Deve mostrar uma lista de empresas")
    public void listEmpresasTest() throws Exception {
        Empresa empresa = new Empresa(1l, "Coca", "cocacola@mail.com","Coca-Cola LTDA", "111.111");
        Empresa empresa2 = new Empresa(2l, "Pepsi", "pepsi@mail.com","Pepsi LTDA", "222.222");
        List<Empresa> listaEmpresa = new ArrayList<>();
        listaEmpresa.add(empresa);
        listaEmpresa.add(empresa2);
        Mockito.when(empresaRepository.findAll()).thenReturn(listaEmpresa);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/listaEmpresas");

        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(listaEmpresa.size())));
    }
}
