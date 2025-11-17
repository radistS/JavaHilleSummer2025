package com.spring.data.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.data.mongodb.model.Tutorial;
import com.spring.data.mongodb.repository.TutorialRepository;

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    @Override
    public List<Tutorial> findAll() {
        return tutorialRepository.findAll();
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {
        return tutorialRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public Optional<Tutorial> findById(String id) {
        return tutorialRepository.findById(id);
    }

    @Override
    public Tutorial createTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    @Override
    public Optional<Tutorial> updateTutorial(String id, Tutorial tutorial) {
        Optional<Tutorial> existing = tutorialRepository.findById(id);
        if (existing.isPresent()) {
            Tutorial _tutorial = existing.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPublished(tutorial.isPublished());
            return Optional.of(tutorialRepository.save(_tutorial));
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(String id) {
        tutorialRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        tutorialRepository.deleteAll();
    }

    @Override
    public List<Tutorial> findByPublished(boolean published) {
        return tutorialRepository.findByPublished(published);
    }
}

