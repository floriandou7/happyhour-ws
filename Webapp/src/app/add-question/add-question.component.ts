import { Component, OnInit } from '@angular/core';
import {Question, QuestionService} from '../service/question.service';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit {

  question: Question = new Question(0, '');

  constructor(
    private questionService: QuestionService
  ) { }

  ngOnInit() {
  }

  createQuestion(): void {
    this.questionService.createQuestion(this.question)
      .subscribe( data => {
        alert('Question created successfully : ' + data.text);
      });
  }
}
