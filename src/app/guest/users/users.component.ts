import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
import { Router } from '@angular/router';
import { PlaylistService } from 'src/service/playlist.service';
import { PlaylistDTO } from 'src/dto/playlistdto';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  playlists: PlaylistDTO[];
  user: UserDTO;
  users: UserDTO[];
  usertoinsert: UserDTO = new UserDTO();

  constructor(private service: UserService, private router: Router ,private servicePlaylist: PlaylistService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'))
    this.getUsers();
  }

  getUsers() {
    this.service.getAll().subscribe(users => this.users = users);
  }

  delete(user: UserDTO) {

    this.service.delete(user.id).subscribe(() => this.getUsers());
    localStorage.clear();
    this.router.navigateByUrl('');
    
  }

  update(user: UserDTO) {

    this.service.update(user).subscribe(() => this.getUsers());

  }

  insert(user: UserDTO) {
    this.service.insert(user).subscribe(() => this.getUsers());
  }

  clear(){
    this.usertoinsert = new UserDTO();
  }
}
