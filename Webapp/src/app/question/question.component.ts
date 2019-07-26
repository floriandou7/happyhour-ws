import { Component, OnInit } from '@angular/core';
import {Question, QuestionService} from '../service/question.service';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

  private questions: Array<Question>;

  constructor(
    private questionService: QuestionService
  ) { }

  ngOnInit() {
    this.questionService.getQuestions().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
  }

  deleteQuestion(question: Question): void {
    this.questionService.deleteQuestion(question)
      .subscribe( data => {
        this.questions = this.questions.filter(u => u !== question);
      });
  }

  editQuestion(question: Question): void {
    this.questionService.updateQuestion(question)
      .subscribe(data => {
        alert('Question edited successfully : ' + data.text);
      });
  }

    handleSuccessfulResponse(response) {
    this.questions = response;
  }
}

