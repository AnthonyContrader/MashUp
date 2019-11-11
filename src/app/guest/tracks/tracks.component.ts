import { Component, OnInit, Input } from '@angular/core';
import { TrackService } from 'src/service/track.service';
import { TrackDTO } from 'src/dto/trackdto';
import { AlbumDTO } from 'src/dto/albumdto';
import { AlbumService } from 'src/service/album.service';
import { PlaylistService } from 'src/service/playlist.service';
import { UserDTO } from 'src/dto/userdto';
import { PlaylistDTO } from 'src/dto/playlistdto';
import { TPDTO } from 'src/dto/tpdto';
import { TPService } from 'src/service/tp.service';

@Component({
  selector: 'app-tracks',
  templateUrl: './tracks.component.html',
  styleUrls: ['./tracks.component.css']
})
export class TracksComponent implements OnInit {
  @Input()track: TrackDTO;
  albums: AlbumDTO[];
  tracks: TrackDTO[];
  playlists: PlaylistDTO[];
  tptoinsert: TPDTO = new TPDTO();
  user: UserDTO;
  constructor(private tpservice: TPService, private service: TrackService, private albumService: AlbumService, private playService: PlaylistService) { }
  

  ngOnInit() {
    this
    this.user = JSON.parse(localStorage.getItem('currentUser'))
    this.getAllAlbums();
    this.getTracks();
    this.getPlaylistByUser();
  }

  getTracks() {
    this.service.getAll().subscribe(tracks => this.tracks = tracks);
  }

  getAllAlbums(){
    this.albumService.getAll().subscribe(albums => this.albums = albums);
  }

  getPlaylistByUser(){
    this.playService.getByUser(this.user).subscribe(playlists => this.playlists = playlists);
  }

  delete(track: TrackDTO){
    this.service.delete(track.id).subscribe(() => this.getTracks());
  }

  update(track: TrackDTO){
    this.service.update(track).subscribe(() => this.getTracks());
  }

  insert(tp: TPDTO){
 
    console.log(tp);
    this.tpservice.insert(tp).subscribe(() => this.getTracks());
  }

  clear(){
    this.tptoinsert = new TPDTO();
  }


}
