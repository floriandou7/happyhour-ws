import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


export class Question {
  constructor(
    public id: number,
    public text: string
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(
    private httpClient: HttpClient
  ) { }
  getQuestions() {
    return this.httpClient.get<Question[]>('http://localhost:8080/api/questions');
  }

  public deleteQuestion(question: Question) {
    return this.httpClient.delete<Question>('http://localhost:8080/api/question' + '/' + question.id);
  }

  public createQuestion(question: Question) {
    return this.httpClient.post<Question>('http://localhost:8080/api/questions', question);
  }

  public updateQuestion(question: Question) {
    return this.httpClient.put<Question>('http://localhost:8080/api/question' + '/' + question.id, question);
  }
}
