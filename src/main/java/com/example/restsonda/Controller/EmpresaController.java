package com.example.restsonda.Controller;

import com.example.restsonda.Model.Empresa;
import com.example.restsonda.Repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmpresaController {


    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @GetMapping("/listaEmpresas")
    @ResponseStatus(HttpStatus.OK)
    private List<Empresa> listarEmpresas(@PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable pageable) {

        return empresaRepository.findAll();



    }

    @GetMapping("/listaEmpresasPag")
    @ResponseStatus(HttpStatus.OK)
    private Page<Empresa> listarEmpresasPaginada(@PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable pageable) {

        Page<Empresa> empresas = empresaRepository.findAll(pageable);

        return empresas;


    }
}
