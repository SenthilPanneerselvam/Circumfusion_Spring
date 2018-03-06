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
	        System.out.println(System.getenv("DATABASE_URL"));
	    		URI dbUri = new URI(System.getenv("DATABASE_URL"));

	        String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();

	        MysqlDataSource basicDataSource = new MysqlDataSource();
	        System.out.println(username);
	        System.out.println(password);
	        System.out.println(dbUrl);
	        basicDataSource.setUrl(dbUrl);
	        basicDataSource.setUser(username);
	        basicDataSource.setPassword(password);

	        return basicDataSource;
	    }
	    
	    public static void main(String[] args) throws URISyntaxException {
    		URI dbUri = new URI("mysql://circumfusion:a$pire123@circumfusion.c8zaohug6wm6.us-east-2.rds.amazonaws.com:3306/circumfusion");

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
        System.out.println(username);
        System.out.println(password);
        System.out.println(dbUrl);
	    }

}
