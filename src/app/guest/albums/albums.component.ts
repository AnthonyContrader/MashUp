import { Component, OnInit } from '@angular/core';
import { AlbumDTO } from 'src/dto/albumdto';
import { AlbumService } from 'src/service/album.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
  styleUrls: ['./albums.component.css']
})
export class AlbumsComponent implements OnInit {

  albums: AlbumDTO[];
  album: AlbumDTO;
  
  constructor(private service: AlbumService, private router: Router){ }


  ngOnInit() {
    this.getAlbums();
  }

  getAlbums(){
    this.service.getAll().subscribe(albums => this.albums = albums);
  }

  open(albumt: AlbumDTO){
    
    localStorage.setItem('albumt', JSON.stringify(albumt));
    this.router.navigate(['/guest-dashboard/albumtracks']);

  }

 
}
