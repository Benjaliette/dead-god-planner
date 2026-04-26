package com.dgp.enregistrerresourcesjeu;

import com.dgp.core.config.DgpCoreConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DgpCoreConfig.class)
public class EnregistrerResourcesJeuBatch {
    public static void main(String[] args) {
        SpringApplication.run(EnregistrerResourcesJeuBatch.class, args);

    }
}