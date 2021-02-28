package com.watlas.produto.config;

import com.watlas.produto.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DbService dbService;

    @Bean
    public void instanciaBaseDeDados() {
        this.dbService.instanciaBaseDeDados();
    }
}
