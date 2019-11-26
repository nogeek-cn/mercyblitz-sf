package com.darian.springbootweb.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspDemoController {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("message", "darian");
        return "index";
    }

}
