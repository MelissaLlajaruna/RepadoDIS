package DIS.RepasoExtraordinaria.fronted;

import DIS.RepasoExtraordinaria.template;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.web.client.RestTemplate;

public class formulario {

    public static class Formulario extends VerticalLayout {

        private TextField nombre= new TextField("Nombre");
        private TextField categoria= new TextField("Categoria");
        private  TextField precio = new TextField("precio");
        private  TextField EAN13 = new TextField("EAN13");

        private Button guardar= new Button("Guardar");

        public Formulario(){
            add(nombre,categoria,precio, EAN13);
            guardar.addClickListener(e->guardarProducto());
            add(guardar);
        }

        private void guardarProducto(){
            RestTemplate restTemplate= new RestTemplate();
            template nuevoProducto= new template();
            nuevoProducto.setNombre(nombre.getValue());
            nuevoProducto.setCategoria(categoria.getValue());
            nuevoProducto.setPrecio(Double.valueOf(precio.getValue()));
            nuevoProducto.setEAN13(EAN13.getValue());

            restTemplate.postForEntity("http://localhost:8080/POST",nuevoProducto,template.class);
        }

}
