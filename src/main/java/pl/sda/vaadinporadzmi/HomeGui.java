package pl.sda.vaadinporadzmi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

@Route("")
@StyleSheet("/css/style.css")
public class HomeGui extends Div implements RouterLayout {

    public HomeGui() {

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


        // HEADER
        Image image = new Image("/images/advice_small.png", "Advice image logo.");

        TextField textField = new TextField();
        textField.setPlaceholder("Poradź mi...");
        textField.addClassName("textField");

        Button buttonSearch = new Button("Szukaj", new Icon(VaadinIcon.SEARCH));
        buttonSearch.addClickListener(click -> {
            Notification.show("Wyszukiwanie zakończone.");
        });

        buttonSearch.addClassName("buttonSearch");

        Button buttonAsk = new Button("Zadaj pytanie", new Icon(VaadinIcon.QUESTION_CIRCLE_O));
        buttonAsk.addClickListener(e ->
                buttonAsk.getUI().ifPresent(ui ->
                        ui.navigate("question")));

        buttonAsk.addClassName("buttonAsk");

        Button buttonNewAccount = new Button("Utwórz konto", new Icon(VaadinIcon.USER));
        buttonNewAccount.addClickListener(click -> {
            Notification.show("Gratulacje - utworzono nowe konto.");
        });
        buttonNewAccount.addClassName("buttonNewAccount");

        Button buttonLogin = new Button("Zaloguj", new Icon(VaadinIcon.SIGN_IN));
        buttonLogin.addClickListener(click -> {
            Notification.show("Zalogowano!");
        });
        buttonLogin.addClassName("buttonLogin");

        // MENU Buttons
        Button buttonHome = new Button("Strona Główna", new Icon(VaadinIcon.HOME));
        buttonHome.addClickListener(e ->
                buttonHome.getUI().ifPresent(ui ->
                        ui.navigate("")));

        Button buttonQuestion = new Button("Pytania", new Icon(VaadinIcon.QUESTION));
        buttonQuestion.addClickListener(e ->
                buttonQuestion.getUI().ifPresent(ui ->
                        ui.navigate("gridAll")));

        Button buttonUsers = new Button("Użytkownicy", new Icon(VaadinIcon.USERS));
        buttonUsers.addClickListener(click -> {
            Notification.show("Użytkownicy!");
        });

        Button buttonTags = new Button("Tagi", new Icon(VaadinIcon.TAGS));
        buttonTags.addClickListener(e ->
                buttonTags.getUI().ifPresent(ui ->
                        ui.navigate("tags")));

        Button buttonHelp = new Button("Pomoc", new Icon(VaadinIcon.AMBULANCE));
        buttonHelp.addClickListener(click -> {
            Notification.show("Pomoc!");
        });

        Button buttonContact = new Button("Kontakt", new Icon(VaadinIcon.MAILBOX));
        buttonContact.addClickListener(click -> {
            Notification.show("Formularz kontaktowy!");
        });

        header.add(image);
        header.add(textField, buttonSearch);
        header.add(buttonAsk);
        header.add(buttonNewAccount);
        header.add(buttonLogin);

        menu.add(buttonHome);
        menu.add(buttonUsers);
        menu.add(buttonQuestion);
        menu.add(buttonTags);
        menu.add(buttonHelp);
        menu.add(buttonContact);

        // CONTENT
        content.add(new H4("CONTENT:"));
//        content.add(new RouterLink("Wszystkie wpisy", QuestionGridGui.class));

        // FOOTER
        Label copyright = new Label("Copyright © 2019 by Marek Michalski.");
        copyright.addClassName("copyright");
        footer.add(copyright);

        // Compose layout
        center.add(menu, content);
        add(header, center, footer);
    }
}

