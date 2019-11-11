import { Component, OnInit } from '@angular/core';
import { TrackDTO } from 'src/dto/trackdto';
import { TrackService } from 'src/service/track.service';
import { AlbumService } from 'src/service/album.service';
import { AlbumDTO } from 'src/dto/albumdto';

@Component({
  selector: 'app-albumtracks',
  templateUrl: './albumtracks.component.html',
  styleUrls: ['./albumtracks.component.css']
})
export class AlbumtracksComponent implements OnInit {
  
  album: AlbumDTO;
  tracks: TrackDTO[];

  constructor(private service: TrackService) { }

  ngOnInit() {
    this.album= JSON.parse(localStorage.getItem('albumt'));
    this.getTracks();
    
  }

  getTracks(){
    this.service.getTrackByAlbum(this.album).subscribe(tracks => this.tracks = tracks);
  }

}
