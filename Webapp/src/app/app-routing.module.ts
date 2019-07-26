import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {QuestionComponent} from './question/question.component';
import {AddQuestionComponent} from './add-question/add-question.component';


const routes: Routes = [
  { path: '', component: QuestionComponent },
  { path: 'add', component: AddQuestionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
