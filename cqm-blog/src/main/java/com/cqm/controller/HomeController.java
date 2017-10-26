package com.cqm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by qmcheng on 2017/10/19 0019.
 */
@Controller
public class HomeController {

  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/")
  public String home(){
    return "index";
  }

  @GetMapping("/index")
  public String index(){
    ConcurrentHashMap c = new ConcurrentHashMap();
    return "index";
  }
}
