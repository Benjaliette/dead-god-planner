package com.dgp.enregistrerresourcesjeu.config;

import com.dgp.enregistrerresourcesjeu.item.PlayerDto;
import com.dgp.enregistrerresourcesjeu.mapper.PlayerMapper;
import com.dgp.core.model.Player;
import com.dgp.enregistrerresourcesjeu.processor.ResourceJeuProcessor;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.JobExecution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.launch.support.JobOperatorFactoryBean;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.StepExecution;
import org.springframework.batch.core.step.builder.ChunkOrientedStepBuilder;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.batch.infrastructure.item.database.JpaItemWriter;
import org.springframework.batch.infrastructure.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.infrastructure.item.xml.StaxEventItemReader;
import org.springframework.batch.infrastructure.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.PlatformTransactionManager;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
@EnableBatchProcessing
public class EnregistrerResourcesJeuBatchConfig {
    @Bean
    @StepScope
    public StaxEventItemReader<PlayerDto> resourceJeuReader(@Value("#{stepExecution}") StepExecution stepExecution) throws MalformedURLException {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(PlayerDto.class);

        JobExecution jobExecution = stepExecution.getJobExecution();
        JobParameters jobParameters = jobExecution.getJobParameters();
        String inputDirectory = jobParameters.getString("inDir");
        String resource = jobParameters.getString("resource");
        String fullUrl = inputDirectory + resource + ".xml";

        //Path filePath = Paths.get(inputDirectory, "/players.xml");

        StaxEventItemReader<PlayerDto> reader = new StaxEventItemReaderBuilder<PlayerDto>()
                .name("playerReader")
                .resource(new UrlResource(fullUrl))
                .addFragmentRootElements("player")
                .unmarshaller(marshaller)
                .build();

        return reader;
    }

    @Bean
    public ItemProcessor<PlayerDto, Player> resourcesProcessor(PlayerMapper playerMapper) {
        return new ResourceJeuProcessor(playerMapper);
    }

    @Bean
    public JpaItemWriter<Player> playerWriter(EntityManagerFactory entityManagerFactory) {
        return new JpaItemWriterBuilder<Player>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }

    @Bean
    public Step importPlayerStep(JobRepository jobRepository,
                                 PlatformTransactionManager transactionManager,
                                 ItemReader<PlayerDto> reader,
                                 ItemProcessor<PlayerDto, Player> processor,
                                 JpaItemWriter<Player> writer) {
        return new ChunkOrientedStepBuilder<PlayerDto, Player>("step", jobRepository, 10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .transactionManager(transactionManager)
                .build();
    }

    @Bean
    public Job importPlayerJob(JobRepository jobRepository, Step importPlayerStep) {
        return new JobBuilder("importPlayerJob", jobRepository)
                .start(importPlayerStep)
                .build();
    }

    @Bean
    public JobOperatorFactoryBean jobOperator(JobRepository jobRepository) {
        JobOperatorFactoryBean jobOperatorFactoryBean = new JobOperatorFactoryBean();
        jobOperatorFactoryBean.setJobRepository(jobRepository);
        jobOperatorFactoryBean.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return jobOperatorFactoryBean;
    }
}
