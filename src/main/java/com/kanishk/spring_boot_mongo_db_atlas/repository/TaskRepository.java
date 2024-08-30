package com.kanishk.spring_boot_mongo_db_atlas.repository;

import com.kanishk.spring_boot_mongo_db_atlas.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findBySeverity(Integer severity);

    @Query("{assignee:?0}")
    List<Task> getByAssignee(String assignee);
}
