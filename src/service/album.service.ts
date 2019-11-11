import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { AlbumDTO } from 'src/dto/albumdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TrackDTO } from 'src/dto/trackdto';

@Injectable({
    providedIn: 'root'
})
export class AlbumService extends AbstractService<AlbumDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'album';
    }
   

}