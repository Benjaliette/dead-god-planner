package com.dgp.enregistrerresourcesjeu.controller;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to handle URLs to launch the batch
 * @author Benjadev 💻
 */
@RestController
public class EnregistrerResourcesJeuBatchController {
    private final JobOperator jobOperator;

    private final Job job;

    public EnregistrerResourcesJeuBatchController(JobOperator jobOperator, Job job) {
        this.jobOperator = jobOperator;
        this.job = job;
    }

    /**
     * Start batch with parameters by going to the following example url :</br>
     * {baseUrl}/start?inDir=/dir&resource=players
     * @param inDir directory where xml game resources are
     * @param resource type of resource to translate
     * @throws Exception
     */
    @GetMapping("/start")
    public void start(@RequestParam String inDir, @RequestParam String resource) throws Exception {
        JobParameters jobParameters = new JobParametersBuilder().addString("inDir", inDir).addString("resource",
                resource).toJobParameters();

        jobOperator.start(job, jobParameters);
    }
}
