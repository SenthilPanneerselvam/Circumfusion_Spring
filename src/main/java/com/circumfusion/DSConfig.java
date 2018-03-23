package com.circumfusion;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration
public class DSConfig {
	

	    @Bean
	    public MysqlDataSource dataSource() throws URISyntaxException {
	    		URI dbUri = new URI("mysql://root:Aspire@localhost:3306/circumfusion");
	    		//URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));

	        String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();

	        MysqlDataSource basicDataSource = new MysqlDataSource();
	        basicDataSource.setUrl(dbUrl);
	        basicDataSource.setUser(username);
	        basicDataSource.setPassword(password);

	        return basicDataSource;
	    }
	    
}
