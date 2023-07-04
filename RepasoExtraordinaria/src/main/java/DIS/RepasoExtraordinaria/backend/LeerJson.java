package DIS.RepasoExtraordinaria.backend;

import DIS.RepasoExtraordinaria.template;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LeerJson {

    public ArrayList<template> leeFicheroJson(){
        try {
            //lee el fichero que le pasamos y lo carga en un reader
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/template.json"));
            // convierte el array JSON a un arraylist de users
            ArrayList<template> listaProductos = new Gson().fromJson(reader, new TypeToken<ArrayList<template>>() {}.getType());
            reader.close();// close reader

            return listaProductos;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<>(); //si no ha leido nada, devuelve un array vacio
        }












    }

}

