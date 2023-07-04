package DIS.RepasoExtraordinaria.backend;


import DIS.RepasoExtraordinaria.template;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ProductoController {
    @GetMapping("/GET")
    public ArrayList<template> GET(){
        ArrayList<template> listaContacto= new LeerJson().leeFicheroJson();
        return listaContacto;
    }
}
