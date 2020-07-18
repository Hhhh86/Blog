package com.hyp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ProjectName blog
 * @ClassName AboutShowController
 * @create 2020-07-17 18:03
 * @Author by hyp
 */
@Controller
public class AboutShowController {

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
