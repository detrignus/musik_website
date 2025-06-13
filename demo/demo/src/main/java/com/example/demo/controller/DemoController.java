package com.example.demo.controller;
import com.example.demo.DemoDTO;
import com.example.demo.model.Feedback;
import com.example.demo.repository.FeedbackRepository;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8052")
public class DemoController {

@Autowired
private FeedbackRepository feedbackRepository;

@PostMapping("/submit")
public ResponseEntity<String> submitFeedback(@RequestBody DemoDTO demo) {
    System.out.println("Получена обратная связь: " + demo.getName() + " - " + demo.getMessage());
    Feedback feedback = new Feedback();
    feedback.setName(demo.getName());
    feedback.setMessage(demo.getMessage());
    feedbackRepository.save(feedback); // Теперь передается Feedback
    return ResponseEntity.ok("Спасибо за ваш отзыв!");
}

@GetMapping("/feedbacks")
public List<Feedback> getAllFeedbacks() {
    return feedbackRepository.findAll();
}
}