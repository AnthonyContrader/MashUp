import { Component, OnInit } from '@angular/core';
import { PlaylistDTO } from 'src/dto/playlistdto';
import { PlaylistService } from 'src/service/playlist.service';
import { UserDTO } from 'src/dto/userdto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-playlists',
  templateUrl: './playlists.component.html',
  styleUrls: ['./playlists.component.css']
})
export class PlaylistsComponent implements OnInit {

  user: UserDTO;
  playlists: PlaylistDTO[];
  playlist: PlaylistDTO;
  playlisttoinsert: PlaylistDTO = new PlaylistDTO
  constructor(private service: PlaylistService,private router: Router) { }

  ngOnInit() {
    this.user= JSON.parse(localStorage.getItem('currentUser'));
    this.getByUser();
  }


  getByUser(){
    this.service.getByUser(this.user).subscribe(playlists => this.playlists = playlists);
  }

  open(play: PlaylistDTO){
    localStorage.setItem("playlistt", JSON.stringify(play))
    this.router.navigate(['/guest-dashboard/playlisttracks'])
  }

  delete(playlist: PlaylistDTO){
    this.service.delete(playlist.id).subscribe(()=> this.getByUser());
  }

  update(playlist: PlaylistDTO){
    this.service.update(playlist).subscribe(()=> this.getByUser());
  }

  insert(playlist: PlaylistDTO) {
    playlist.userDTO= this.user;
    this.service.insert(playlist).subscribe(() => this.getByUser());
  }

  clear(){
    this.playlisttoinsert = new PlaylistDTO();

}}
