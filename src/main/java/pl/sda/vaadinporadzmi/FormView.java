package pl.sda.vaadinporadzmi;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route("form")
public class FormView extends FormLayout {

    public FormView() {
        Person model = new Person();

        TextField firstNameField = new TextField("First Name");
        Binder<Person> binder1 = new Binder<>(Person.class);

        binder1.forField(firstNameField).bind(Person::getFirstName, Person::setFirstName);

        TextField lastNameField = new TextField("Last Name");
        Binder<Person> binder2 = new Binder<>(Person.class);

        binder2.forField(firstNameField).bind(Person::getLastName, Person::setLastName);

        // One-way data binding
        // binder.readBean(model);

        // Two-way data binding
        binder1.setBean(model);
        binder2.setBean(model);

        add(firstNameField, lastNameField);
    }
}

