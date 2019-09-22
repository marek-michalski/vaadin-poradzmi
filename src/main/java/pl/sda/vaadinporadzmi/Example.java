package pl.sda.vaadinporadzmi;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;


@Tag(value = "header")
@Route(value = "example", layout = HomeGui.class)
public class Example extends Div implements RouterLayout {

    public Example(QuestionApi question) {

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

