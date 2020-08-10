package com.revature.dao;

import com.revature.model.Category;
import com.revature.model.Flashcard;

import javax.faces.context.Flash;
import java.util.Set;

public class FlashcardRepository implements CrudRepository<Flashcard> {

    public Set<Flashcard> findFlashCardByCategory(Category category){
        return null;
    }

    public Set<Flashcard> findFlashCardsByQuestion(String question){
        return null;
    }

    @Override
    public Flashcard save(Flashcard flashcard) {
        return null;
    }

    @Override
    public Set<Flashcard> findAll() {
        return null;
    }

    @Override
    public Flashcard findById(Integer id) {
        return null;
    }

    @Override
    public boolean update(Flashcard flashcard) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}