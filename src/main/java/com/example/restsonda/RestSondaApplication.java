package com.example.restsonda;

import com.example.restsonda.Model.Empresa;
import com.example.restsonda.Repository.EmpresaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class RestSondaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestSondaApplication.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(RestSondaApplication.class);

    @Bean
    public CommandLineRunner save(EmpresaRepository empresaRepository) {
        return (args -> {
            log.info("Preenchendo Banco de dados...");
            empresaRepository.save(new Empresa(1L,"Coca", "cocacola@mail.com", "Coca-Cola LTDA", "111.111"));
            empresaRepository.save(new Empresa(2L,"Pepsi", "pepsi@mail.com", "Pepsi LTDA", "222.222"));
            empresaRepository.save(new Empresa(3L,"Fanta", "fanta@mail.com", "Fanta LTDA", "333.333"));
            empresaRepository.save(new Empresa(4L,"Antártica", "antartica@mail.com", "Antártica LTDA", "444.444"));
            empresaRepository.save(new Empresa(5L,"Dolly", "dolly@mail.com", "Dolly LTDA", "555.555"));
            empresaRepository.save(new Empresa(6L,"Kuat", "kuat@mail.com", "Kuat LTDA", "666.666"));
            empresaRepository.save(new Empresa(7L,"Sprite", "sprite@mail.com", "Sprite LTDA", "777.777"));
            empresaRepository.save(new Empresa(8L,"Sukita", "sukita@mail.com", "Sukita LTDA", "888.888"));
            empresaRepository.save(new Empresa(9L,"Refri", "refri@mail.com", "Refri LTDA", "999.999"));
            empresaRepository.save(new Empresa(10L,"Frevo", "frevo@mail.com", "Frevo LTDA", "101.101"));
            log.info("Banco de dados preenchido");
        });




    }

}
