package pl.sda.vaadinporadzmi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("question")
public class QuestionGui extends VerticalLayout {

    @Autowired
    private QuestionRepo questionRepo;

    private TextField textFieldType = new TextField("Podaj rodzaj pytania:");
    private TextField textFieldTags = new TextField("Wskaż tagi:");
    private TextField textFieldTitle = new TextField("Podaj tytuł:");
    private TextArea textAreaDescription = new TextArea("Opisz swój problem:");
    private Button buttonAdd = new Button("Dodaj");


    public QuestionGui() {

        add(textFieldType, textFieldTags, textFieldTitle, textAreaDescription, buttonAdd);

        buttonAdd.addClickListener(click -> {
            Notification.show("Dodano do bazy!");
        });

        buttonAdd.addClickListener(clickEvent -> {
            Question question = new Question();
            question.setType(textFieldType.getValue());
            question.setTags(textFieldTags.getValue());
            question.setTitle(textFieldTitle.getValue());
            question.setDescription(textAreaDescription.getValue());
            questionRepo.save(question);
        });
    }

}
