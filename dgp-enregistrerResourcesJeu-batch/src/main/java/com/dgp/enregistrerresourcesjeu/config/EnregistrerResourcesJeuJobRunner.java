package com.dgp.enregistrerresourcesjeu.config;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnregistrerResourcesJeuJobRunner implements ApplicationRunner {
    private final JobOperator batchJobOperator;
    private final Job importPlayerJob;

    public EnregistrerResourcesJeuJobRunner(@Qualifier("jobOperator")  JobOperator batchJobOperator, Job importPlayerJob) {
        this.batchJobOperator = batchJobOperator;
        this.importPlayerJob = importPlayerJob;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String inDir = extractArg(args, "inDir");
        String resourceType = extractArg(args, "resourceType");

        if (inDir == null || inDir.isBlank()) {
            throw new IllegalArgumentException("Le paramètre 'inDir' est obligatoire !");
        }
        if (resourceType == null || resourceType.isBlank()) {
            throw new IllegalArgumentException("Le paramètre 'resourceType' est obligatoire !");
        }

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("inDir", inDir)
                .addString("resourceType", resourceType)
                .addLong("run.id", System.currentTimeMillis())
                .toJobParameters();

        batchJobOperator.start(importPlayerJob, jobParameters);
    }

    private String extractArg(ApplicationArguments args, String key) {
        if (args.containsOption(key)) {
            List<String> values = args.getOptionValues(key);
            if (values != null && !values.isEmpty()) {
                return values.getFirst();
            }
        }
        return null;
    }
}
