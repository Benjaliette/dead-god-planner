package com.dgp.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class AbstractDgpUnitTest {
    private LocalDateTime now;

    @BeforeEach
    public void initDate() {
        now = LocalDateTime.now();
    }
}
