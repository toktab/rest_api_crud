package dev.toktab.rest_api_crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserFormController {
    
    @GetMapping("/user-form")
    @ResponseBody//for rest
    //@Controller for basic html returns. @RestController for basic value returns
    //if we want a @Controller to return a @Restcontroller basic value instead of html
    //we use this @ResponseBody
    public String showUserForm(){
        return "gamarjoba all"; // This corresponds to the HTML file name without the extension
    }
}
