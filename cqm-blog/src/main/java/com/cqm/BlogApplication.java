package com.cqm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by qmcheng on 2017/10/19 0019.
 */
@SpringBootApplication
public class BlogApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    builder.sources(BlogApplication.class);
    return super.configure(builder);
  }

  public static void main(String[]args){
    SpringApplication.run(BlogApplication.class, args);
  }
}
