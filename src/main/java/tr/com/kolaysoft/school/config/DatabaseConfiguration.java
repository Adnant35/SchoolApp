package tr.com.kolaysoft.school.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({ "tr.com.kolaysoft.school.repository" })
@EnableTransactionManagement
public class DatabaseConfiguration {}
