import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { PlaylistDTO} from 'src/dto/playlistdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class PlaylistService extends AbstractService<PlaylistDTO>{

    constructor(http: HttpClient) {
        super (http);
        this.type = 'playlist';
    }


}