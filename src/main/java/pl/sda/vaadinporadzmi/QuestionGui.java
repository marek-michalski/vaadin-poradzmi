package pl.sda.vaadinporadzmi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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
    private TextField textFieldDescription = new TextField("Opisz swój problem:");
    private Button buttonAdd = new Button("Dodaj");

    public QuestionGui() {

        add(textFieldType, textFieldTags, textFieldTitle, textFieldDescription, buttonAdd);

        buttonAdd.addClickListener(clickEvent-> {
            Question question = new Question();
            question.setType(textFieldType.getValue());
            question.setTags(textFieldTags.getValue());
            question.setTitle(textFieldTitle.getValue());
            question.setDescription(textFieldDescription.getValue());
            questionRepo.save(question);
        });
    }

}
