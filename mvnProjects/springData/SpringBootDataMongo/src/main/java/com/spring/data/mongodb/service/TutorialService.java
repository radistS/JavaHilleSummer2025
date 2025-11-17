package com.spring.data.mongodb.service;

import java.util.List;
import java.util.Optional;

import com.spring.data.mongodb.model.Tutorial;

public interface TutorialService {
    List<Tutorial> findAll();
    List<Tutorial> findByTitleContaining(String title);
    Optional<Tutorial> findById(String id);
    Tutorial createTutorial(Tutorial tutorial);
    Optional<Tutorial> updateTutorial(String id, Tutorial tutorial);
    void deleteById(String id);
    void deleteAll();
    List<Tutorial> findByPublished(boolean published);
}

