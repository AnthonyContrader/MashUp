import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-work-in-progress',
  templateUrl: './work-in-progress.component.html',
  styleUrls: ['./work-in-progress.component.css']
})
export class WorkInProgressComponent implements OnInit {

  user: UserDTO;
  constructor() { }

  ngOnInit() {
    this.user=JSON.parse(localStorage.getItem('currentUser'));
  }

}
