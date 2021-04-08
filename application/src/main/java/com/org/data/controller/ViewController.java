package com.org.data.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
  
/**
 * Controller to load the index.html
 * @author Kishore Hebbar
 *
 */

@Controller
public class ViewController {
  
    @RequestMapping("/")
    public String welcome() {
        return "index";
    }
}