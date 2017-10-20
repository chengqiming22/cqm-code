package com.cqm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by qmcheng on 2017/10/19 0019.
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer  extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    builder.sources(EurekaServer.class);
    return super.configure(builder);
  }

  public static void main(String[]args){
    new SpringApplicationBuilder(EurekaServer.class).web(true).run(args);
  }
}
