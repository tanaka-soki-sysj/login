package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseRegistController {

    @RequestMapping("/registFirst")
    public String first() {
        return "courseApp/applicationMenu";
    }

}
