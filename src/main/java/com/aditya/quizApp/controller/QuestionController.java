package com.aditya.quizApp.controller;

import com.aditya.quizApp.Questions;
import com.aditya.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    // endpoint to get all questions
    @GetMapping("getQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    // endpoint to get questions by category
    @GetMapping("category/{category}")
    public ResponseEntity<List<Questions>> getQuestionsByCat(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    // endpoint to add new questions
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }
}
