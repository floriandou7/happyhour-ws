package com.floriandoussin.HappyHour.repository

import com.floriandoussin.HappyHour.entities.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository : JpaRepository<Question, Long>
