package pl.sda.vaadinporadzmi;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("gridAll")
public class QuestionGridGui extends VerticalLayout {

    public QuestionGridGui(QuestionApi question) {
        Grid<Question> grid = new Grid<>();
        grid.addColumn(Question::getId).setHeader("Id");
        grid.addColumn(Question::getType).setHeader("Typ");
        grid.addColumn(Question::getTags).setHeader("Tag");
        grid.addColumn(Question::getTitle).setHeader("Tytuł");
        grid.addColumn(Question::getDescription).setHeader("Opis");

        List<Question> questionAll = (List<Question>) question.getAll();
        grid.setItems(questionAll);

        add(grid);
    }

}
