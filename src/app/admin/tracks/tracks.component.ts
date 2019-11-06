import { Component, OnInit } from '@angular/core';
import { TrackService } from 'src/service/track.service';
import { TrackDTO } from 'src/dto/trackdto';

@Component({
  selector: 'app-tracks',
  templateUrl: './tracks.component.html',
  styleUrls: ['./tracks.component.css']
})
export class TracksComponent implements OnInit {

  tracks: TrackDTO[];
  tracktoinsert: TrackDTO = new TrackDTO();

  constructor(private service: TrackService) { }

  ngOnInit() {
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
}
