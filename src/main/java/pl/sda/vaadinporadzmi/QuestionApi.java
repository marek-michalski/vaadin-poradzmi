package pl.sda.vaadinporadzmi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionApi {

    @Autowired
    private QuestionRepo questionRepo;

    @PostMapping("/addQuestion")
    public void addQuestion(@RequestBody Question question) {
        questionRepo.save(question);
    }

    @DeleteMapping("/deleteQuestion")
    public void deleteQuestion(@RequestParam("id") Long id) {
        questionRepo.deleteById(id);
    }

    @GetMapping("/getAll")
    public Iterable<Question> getAll() {
        return questionRepo.findAll();
    }

    @GetMapping("/findQuestionByTags")
    public Iterable<Question> findQuestionByTags(@RequestParam("tags") String tags) {
        return questionRepo.findQuestionByTags(tags);
    }

}
