package com.floriandoussin.HappyHour.controller

@RestController
class QuestionController {

    @RequestMapping("/")
    fun index(): String {
        return "Greetings from Spring Boot!"
    }

}
