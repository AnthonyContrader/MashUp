import { Component, OnInit } from '@angular/core';
import { TrackService } from 'src/service/track.service';
import { TrackDTO } from 'src/dto/trackdto';
import { AlbumDTO } from 'src/dto/albumdto';
import { AlbumService } from 'src/service/album.service';

@Component({
  selector: 'app-tracks',
  templateUrl: './tracks.component.html',
  styleUrls: ['./tracks.component.css']
})
export class TracksComponent implements OnInit {

  albums: AlbumDTO[];
  tracks: TrackDTO[];
  tracktoinsert: TrackDTO = new TrackDTO();

  constructor(private service: TrackService, private albumService: AlbumService) { }
  

  ngOnInit() {
        this.getAllAlbums();
    this.getTracks();
  }

  getTracks() {
    this.service.getAll().subscribe(tracks => this.tracks = tracks);
  }

  delete(track: TrackDTO){
    this.service.delete(track.id).subscribe(() => this.getTracks());
  }

  update(track: TrackDTO){
    this.service.update(track).subscribe(() => this.getTracks());
  }

  insert(track: TrackDTO){
    this.service.insert(track).subscribe(() => this.getTracks());
  }

  clear(){
    this.tracktoinsert = new TrackDTO();
  }

  getAllAlbums(){
    this.albumService.getAll().subscribe(albums => this.albums = albums);
  }
}
