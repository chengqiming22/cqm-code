package com.cqm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qmcheng on 2017/10/19 0019.
 */
@Controller
@RequestMapping("/")
public class HomeController {

  @GetMapping("")
  public String home(){
    return "index";
  }

  @GetMapping("index")
  public String index(){
    return "redirect:/";
  }
}
