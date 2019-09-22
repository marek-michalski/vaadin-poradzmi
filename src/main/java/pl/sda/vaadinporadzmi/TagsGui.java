package pl.sda.vaadinporadzmi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("tags")
public class TagsGui extends VerticalLayout {

    @Autowired
    private QuestionRepo questionRepo;

    private TextField textFieldTags = new TextField("Podaj szukany TAG:");
    private Button button = new Button("Wyświetl");

//    private TextArea textArea = new TextArea();

//    public TagsGui() {
//        add(textFieldTags);
//        add(button);
//        add(textArea);
//        button.addClickListener(clickEvent -> {
//            Question question = new Question();
//            List<Question> questionWhereTagsIs = questionRepo.findQuestionByTags(textFieldTags.getValue());
//            textArea.setValue(questionWhereTagsIs.toString());
//        });
//    }

    public TagsGui() {
        add(textFieldTags);
        add(button);
        button.addClickListener(clickEvent -> {
            Grid<Question> grid = new Grid<>();
            grid.addColumn(Question::getId).setHeader("Id");
            grid.addColumn(Question::getType).setHeader("Typ");
            grid.addColumn(Question::getTags).setHeader("Tag");
            grid.addColumn(Question::getTitle).setHeader("Tytuł");
            grid.addColumn(Question::getDescription).setHeader("Opis");

            List<Question> questionWhereTagsIs = questionRepo.findQuestionByTags(textFieldTags.getValue());
            grid.setItems(questionWhereTagsIs);
            add(grid);
        });
    }
}
