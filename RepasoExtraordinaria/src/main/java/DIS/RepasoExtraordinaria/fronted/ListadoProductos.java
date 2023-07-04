package DIS.RepasoExtraordinaria.fronted;


import DIS.RepasoExtraordinaria.template;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@PageTitle("Listado Contactos")
@Route(value = "ListadoContactos", layout = MainView.class)

public class ListadoProductos extends VerticalLayout {

    Grid<template> grid = new Grid<>(template.class);

    public ListadoProductos(){
        addClassName("List-view");
        setSizeFull();

        configureGrid(); //GRID DE DATOS
        add(
                getToolBar(),
                getContent()
        );
    }

    private Component getToolBar(){
        Button DeleteContacto = new Button("Eliminar producto seleccionado");
        DeleteContacto.addClickListener(e -> eliminarTweetSeleccionado());
        HorizontalLayout toolbar= new HorizontalLayout(DeleteContacto);
        toolbar.addClassName("Toolbar");
        return toolbar;

    }
    private void eliminarTweetSeleccionado(){
        template productoSeleccionado= grid.getSelectedItems().iterator().next();
        String productoNombre= productoSeleccionado.getNombre();
        RestTemplate restTemplate= new RestTemplate();
        restTemplate.delete("http://localhost:8080/DELETE/{prodcutoNombre}", productoNombre);

        configureGrid();
    }

    private Component getContent(){
        HorizontalLayout content= new HorizontalLayout(grid);
        content.setFlexGrow(2,grid);
        content.addClassName("contect");
        content.setSizeFull();
        return content;
    }

    private void configureGrid(){
        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<ArrayList<template>> response= restTemplate.exchange("http://localhost:8080/GET", HttpMethod.GET, null,new ParameterizedTypeReference<ArrayList<template>>(){});
        ArrayList<template> listaContacto= response.getBody();

        grid.addClassName("contact-grid");
        grid.setSizeFull();

        grid.setColumns("id","nombre","telefono","fecha");
        grid.setItems(listaContacto);

    }





}
