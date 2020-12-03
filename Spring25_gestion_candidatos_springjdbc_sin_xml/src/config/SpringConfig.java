package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@ComponentScan(basePackages = {"service"})
@Configuration
@PropertySource("classpath:config/application.properties")
public class SpringConfig {
	@Value("${gestion.candidatos.driver}")
	String driver;
	@Value("${gestion.candidatos.url}")
	String cadena;
	@Value("${gestion.candidatos.user}")
	String usuario;
	@Value("${gestion.candidatos.pwd}")
	String pw;
	//@Bean
	private DataSource crearDatasource() {
		DriverManagerDataSource data=new DriverManagerDataSource();
		data.setDriverClassName(driver);
		data.setUrl(cadena);
		data.setUsername(usuario);
		data.setPassword(pw);
		return data;
	}
	/*private DataSource crearDatasource() {
        DataSource dataSource = null;
        JndiTemplate jndi = new JndiTemplate();
        try {
            dataSource = jndi.lookup("java:comp/env/refempresa", DataSource.class);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return dataSource;
    }*/
	
	@Bean
	public JdbcTemplate crearTemplate() {
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(crearDatasource());
		return template;
	}
}
