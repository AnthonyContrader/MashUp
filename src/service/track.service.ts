import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { TrackDTO } from 'src/dto/trackdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class TrackService extends AbstractService<TrackDTO>{
    
    constructor(http: HttpClient){
        super(http);
        this.type = 'track';
    }
}