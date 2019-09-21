package pl.sda.vaadinporadzmi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepo extends CrudRepository<Question, Long> {

    @Query(value = "SELECT * FROM QUESTION q WHERE q.TAGS = :tags", nativeQuery = true)
    List<Question> findQuestionByTags(@Param("tags") String tags);
}
