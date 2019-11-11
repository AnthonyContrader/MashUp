import { Component, OnInit } from '@angular/core';
import { TrackDTO } from 'src/dto/trackdto';
import { TPService } from 'src/service/tp.service';
import { TPDTO } from 'src/dto/tpdto';
import { PlaylistDTO } from 'src/dto/playlistdto';

@Component({
  selector: 'app-playlisttracks',
  templateUrl: './playlisttracks.component.html',
  styleUrls: ['./playlisttracks.component.css']
})
export class PlaylisttracksComponent implements OnInit {
  tps: TPDTO[];
  tp: TPDTO;
  playlist: PlaylistDTO;
  tracks: TrackDTO[]
  tptoinsert: TPDTO = new TPDTO;

  constructor(private servicetp: TPService) { }

  ngOnInit() {
    
    this.playlist= JSON.parse(localStorage.getItem("playlistt"))
    this.getTracks();
  }
  getTracks() {
    this.servicetp.getTrackByPlaylist(this.playlist).subscribe(tps => this.tps = tps);
  
    
  }

  delete(tp: TPDTO){
    this.servicetp.delete(tp.id).subscribe(() => this.getTracks());
  }

  

  insert(tp: TPDTO){
    this.servicetp.insert(tp).subscribe(() => this.getTracks());
  }

  clear(){
    this.tptoinsert = new TPDTO();
  }

}
