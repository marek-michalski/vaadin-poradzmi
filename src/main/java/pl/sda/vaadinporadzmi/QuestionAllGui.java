package pl.sda.vaadinporadzmi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("questionAll")
public class QuestionAllGui extends VerticalLayout {

    @Autowired
    private QuestionRepo questionRepo;

    private Button button = new Button("Wyświetl wszystkie pytania.");
    private TextArea textArea = new TextArea();


    public QuestionAllGui() {
        textArea.setMinWidth("1000px");
        textArea.setMinHeight("600px");
        add(textArea, button);
        button.addClickListener(clickEvent -> {
            Iterable<Question> questionRepoAll = questionRepo.findAll();
            textArea.setValue(questionRepoAll.toString());
        });
    }

}
