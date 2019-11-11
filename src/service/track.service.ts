import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { TrackDTO } from 'src/dto/trackdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PlaylistDTO } from 'src/dto/playlistdto';
import { AlbumDTO } from 'src/dto/albumdto';

@Injectable({
    providedIn: 'root'
})
export class TrackService extends AbstractService<TrackDTO>{
    
    constructor(http: HttpClient){
        super(http);
        this.type = 'track';
    }
   
    getTrackByAlbum(albumDTO: AlbumDTO): Observable<TrackDTO[]>{
        return this.http.post<TrackDTO[]>('http://localhost:8080/' + this.type + '/albumtracks', albumDTO)

    }
    
  
}