import { Component, OnInit } from '@angular/core';
import { AlbumDTO } from 'src/dto/albumdto';
import { AlbumService } from 'src/service/album.service';

@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
  styleUrls: ['./albums.component.css']
})
export class AlbumsComponent implements OnInit {

  albums: AlbumDTO[];
  albumtoinsert: AlbumDTO = new AlbumDTO();

  constructor(private service: AlbumService){ }


  ngOnInit() {
    this.getAlbums();
  }

  getAlbums(){
    this.service.getAll().subscribe(albums => this.albums = albums);
  }

  delete(album: AlbumDTO){
    this.service.delete(album.id).subscribe(() => this.getAlbums());
  }

  update(album: AlbumDTO){
    this.service.update(album).subscribe(()=> this.getAlbums());
  }
  
  insert(album: AlbumDTO){
    this.service.insert(album).subscribe(()=> this.getAlbums());
  }

  clear(){
    this.albumtoinsert = new AlbumDTO();
  }
}
