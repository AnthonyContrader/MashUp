import { Component, OnInit } from '@angular/core';
import { TPService } from 'src/service/tp.service';
import { TPDTO } from 'src/dto/tpdto';

@Component({
    selector: 'app-tps',
    templateUrl: './tps.component.html',
    styleUrls: ['./tps.component.css']
})
export class TPsComponent implements OnInit{

    tps: TPDTO[];
    tptoinsert: TPDTO = new TPDTO();

    constructor(private service: TPService){ }

    ngOnInit(){
        this.getTps();
    }

    getTps(){
        this.service.getAll().subscribe(tps => this.tps = tps);
    }

    delete(tp: TPDTO){
        this.service.delete(tp.id).subscribe(() => this.getTps());
    }

    update(tp: TPDTO){
        this.service.update(tp).subscribe(() => this.getTps());
    }

    insert(tp: TPDTO){
        this.service.insert(tp).subscribe(() => this.getTps());
    }
    clear(){
        this.tptoinsert = new TPDTO();
    }
}