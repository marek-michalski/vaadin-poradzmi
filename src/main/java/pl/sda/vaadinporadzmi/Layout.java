package pl.sda.vaadinporadzmi;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
@StyleSheet("/css/style.css")
public class Layout extends Div {

    public Layout() {
        // Instantiate layouts
        HorizontalLayout header = new HorizontalLayout();
        VerticalLayout menu = new VerticalLayout();
        VerticalLayout content = new VerticalLayout();
        Div center = new Div();
        HorizontalLayout footer = new HorizontalLayout();

        // Configure layouts
        setSizeFull();
        header.setPadding(true);
        footer.setPadding(true);
        addClassName("main-view");
        header.addClassName("header");
        menu.addClassName("menu");
        center.addClassName("center");
        content.addClassName("content");
        footer.addClassName("footer");

        // Add content
        header.add("HEADER");
        menu.add("MENU");
        content.add("CONTENT");
        footer.add("FOOTER");

        // Compose layout
        center.add(menu, content);
        add(header, center, footer);
    }
}

