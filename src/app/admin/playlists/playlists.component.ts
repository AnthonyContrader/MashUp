import { Component, OnInit } from '@angular/core';
import { PlaylistDTO } from 'src/dto/playlistdto';
import { PlaylistService } from 'src/service/playlist.service';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-playlists',
  templateUrl: './playlists.component.html',
  styleUrls: ['./playlists.component.css']
})
export class PlaylistsComponent implements OnInit {

  user: UserDTO;
  playlists: PlaylistDTO[];
  playlisttoinsert: PlaylistDTO = new PlaylistDTO
  constructor(private service: PlaylistService) { }

  ngOnInit() {
    this.user= JSON.parse(localStorage.getItem('currentUser'));
    this.getPlaylists();
  }

  getPlaylists(){
    this.service.getAll().subscribe(playlists => this.playlists = playlists);
  }

  delete(playlist: PlaylistDTO){
    this.service.delete(playlist.id).subscribe(()=> this.getPlaylists());
  }

  update(playlist: PlaylistDTO){
    this.service.update(playlist).subscribe(()=> this.getPlaylists());
  }

  insert(playlist: PlaylistDTO) {
    playlist.userDTO= this.user;
    this.service.insert(playlist).subscribe(() => this.getPlaylists());
  }

  clear(){
    this.playlisttoinsert = new PlaylistDTO();

}}
