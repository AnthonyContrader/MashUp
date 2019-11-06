import { Component, OnInit } from '@angular/core';
import { PlaylistDTO } from 'src/dto/playlistdto';
import { PlaylistService } from 'src/service/playlist.service';

@Component({
  selector: 'app-playlists',
  templateUrl: './playlists.component.html',
  styleUrls: ['./playlists.component.css']
})
export class PlaylistsComponent implements OnInit {

  playlists: PlaylistDTO[];
  playlisttoinsert: PlaylistDTO = new PlaylistDTO
  constructor(private service: PlaylistService) { }

  ngOnInit() {
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
    this.service.insert(playlist).subscribe(() => this.getPlaylists());
  }

  clear(){
    this.playlisttoinsert = new PlaylistDTO();
  }
}
