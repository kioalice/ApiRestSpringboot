package org.generation.gestiontareasapp.controllers;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/index")
public class indexRestController {


    @RequestMapping("/index")
    public String vistaHome(){

        return "index";
    }


}

