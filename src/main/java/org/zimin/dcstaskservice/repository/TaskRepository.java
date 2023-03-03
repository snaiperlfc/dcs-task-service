package org.zimin.dcstaskservice.repository;

import io.micrometer.core.annotation.Timed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.zimin.dcstaskservice.domain.Task;

import java.time.LocalDateTime;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "task", path = "task")
public interface TaskRepository extends MongoRepository<Task, String> {

    @Timed("gettingTasksFromDB")
    List<Task> findByStartDateAfter(@Param("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime start);

}
