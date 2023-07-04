package DIS.RepasoExtraordinaria.fronted;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@PageTitle("Productos")
@Route
public class MainView extends AppLayout {

    public MainView(){
        createHeader();
        createDrawer();
    }

    private void createHeader(){
        H1 logo= new H1("Agenda contactos");
        logo.addClassNames("text-l","m-m");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);
    }

    private void createDrawer(){
        RouterLink listLink= new RouterLink("Listado Productos", ListadoProductos.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());
        addToDrawer(new VerticalLayout(listLink,new RouterLink("Alta Producto", AltaProducto.class)));
    }

}
