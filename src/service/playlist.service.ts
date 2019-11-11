import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { PlaylistDTO} from 'src/dto/playlistdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserDTO } from 'src/dto/userdto';

@Injectable({
    providedIn: 'root'
})

export class PlaylistService extends AbstractService<PlaylistDTO>{

    constructor(http: HttpClient) {
        super (http);
        this.type = 'playlist';
    }

    getByUser(userDTO: UserDTO): Observable<PlaylistDTO[]>{
        return this.http.post<PlaylistDTO[]>('http://localhost:8080/' + this.type + '/userplaylist', userDTO)
    }

}