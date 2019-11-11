import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { TPDTO } from 'src/dto/tpdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PlaylistDTO } from 'src/dto/playlistdto';

@Injectable({
    providedIn: 'root'
})
export class TPService extends AbstractService<TPDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'tp';
    }


   getTrackByPlaylist(playlistDTO: PlaylistDTO):Observable<TPDTO[]>{
       return this.http.post<TPDTO[]>('http://localhost:8080/' + this.type + '/trackplaylist', playlistDTO)
   }
}



