import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { TPDTO } from 'src/dto/tpdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class TPService extends AbstractService<TPDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'tp';
    }
}