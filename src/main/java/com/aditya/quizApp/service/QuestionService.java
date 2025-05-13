package com.aditya.quizApp.service;

import com.aditya.quizApp.Questions;
import com.aditya.quizApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Questions> getAllQuestions(){
        return questionDao.findAll();
    }

    public List<Questions> getQuestionsByCategory(String cat) {
        return questionDao.findByCategory(cat);
    }

    public String addQuestion(Questions questions){
        questionDao.save(questions);
        return "Success";
    }
}
