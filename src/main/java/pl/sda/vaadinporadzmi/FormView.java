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
        Binder<Person> binder = new Binder<>(Person.class);

        binder.forField(firstNameField).bind(Person::getFirstName, Person::setFirstName);

        // One-way data binding
        // binder.readBean(model);

        // Two-way data binding
        binder.setBean(model);

        add(firstNameField);
    }
}

