package com.spring.data.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.data.mongodb.model.Tutorial;

public interface TutorialRepository extends MongoRepository<Tutorial, String> { // Crud / Jpa Repository
  List<Tutorial> findByPublished(boolean published);
  List<Tutorial> findByTitleContainingIgnoreCase(String title);
}
