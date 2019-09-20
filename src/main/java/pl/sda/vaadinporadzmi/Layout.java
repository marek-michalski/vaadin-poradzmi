package pl.sda.vaadinporadzmi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
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
        header.add(new H3("PORADŹ MI! :)"));
        menu.add(new H4("MENU"));
        content.add(new H4("CONTENT"));
        footer.add(new H6("Copyright © 2019 by Marek Michalski."));

        Button buttonSearch = new Button("Szukaj");
        buttonSearch.addClickListener(click -> {
            Notification.show("Thanks for clicking!");
        });

        Button buttonQuestion = new Button("Zadaj pytanie");
        buttonQuestion.addClickListener(click -> {
            Notification.show("Thanks for clicking!");
        });

        Button buttonNewAccount = new Button("Utwórz konto");
        buttonNewAccount.addClickListener(click -> {
            Notification.show("Thanks for clicking!");
        });

        Button buttonLogin = new Button("Zaloguj");
        buttonLogin.addClickListener(click -> {
            Notification.show("Thanks for clicking!");
        });

        Label label = new Label("Tutaj powstanie jakiś wpis...");

        header.add(buttonSearch);
        menu.add(buttonQuestion);
        menu.add(buttonNewAccount);
        menu.add(buttonLogin);
        content.add(label);


        // Compose layout
        center.add(menu, content);
        add(header, center, footer);
    }
}

