package com.aditya.quizApp.service;

import com.aditya.quizApp.Questions;
import com.aditya.quizApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Questions>> getAllQuestions(){
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Questions>> getQuestionsByCategory(String cat) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(cat),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<String> addQuestion(Questions questions){
        try{
            questionDao.save(questions);
            return new ResponseEntity<>("Question Added Successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Unable to add question at the moment",HttpStatus.BAD_GATEWAY);
        }
    }
}
