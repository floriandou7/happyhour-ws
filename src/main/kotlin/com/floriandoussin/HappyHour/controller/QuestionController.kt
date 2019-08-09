package com.floriandoussin.HappyHour.controller

import com.floriandoussin.HappyHour.entities.Question
import com.floriandoussin.HappyHour.repository.QuestionRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import java.util.ArrayList
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



@RestController
@CrossOrigin(origins = ["http://localhost:4200"], maxAge = 3600)
@RequestMapping("/api")
class QuestionController(private val questionRepository: QuestionRepository) {

    @RequestMapping("/")
    fun index(): String {
        return "Greetings from Spring Boot!"
    }

    @GetMapping("/questions")
    fun getAllQuestions(): List<Question> =
            questionRepository.findAll()


    @PostMapping("/questions")
    fun createNewQuestion(@Valid @RequestBody question: Question): Question =
            questionRepository.save(question)

    @GetMapping("/questions/{id}")
    fun getQuestionById(@PathVariable(value = "id") questionId: Long): ResponseEntity<Question> {
        return questionRepository.findById(questionId).map { question ->
            ResponseEntity.ok(question)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/question/{id}")
    fun updateQuestionById(@PathVariable(value = "id") questionId: Long,
                          @Valid @RequestBody newQuestion: Question): ResponseEntity<Question> {

        return questionRepository.findById(questionId).map { existingQuestion ->
            val updatedQuestion: Question = existingQuestion
                    .copy(text = newQuestion.text)
            ResponseEntity.ok().body(questionRepository.save(updatedQuestion))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/question/{id}")
    fun deleteQuestionById(@PathVariable(value = "id") questionId: Long): ResponseEntity<Void> {
        return questionRepository.findById(questionId).map { question  ->
            questionRepository.delete(question)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}
