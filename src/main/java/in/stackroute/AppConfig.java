package in.stackroute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan({ "in.stackroute" })
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate template;

    @Bean("dataSource")
    public DriverManagerDataSource getDriver() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.18.0.2:3306/demo");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean("template")
    public JdbcTemplate getTemplate() {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        return template;
    }

    @Bean("personDAO")
    public PersonDAOImp getPersonDAO() {
        PersonDAOImp personDAOImp = new PersonDAOImp();
        personDAOImp.setTemplate(template);
        return personDAOImp;
    }
}
