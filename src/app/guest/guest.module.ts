import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GuestDashboardComponent } from './guest-dashboard/guest-dashboard.component';
import { UsersComponent } from '../guest/users/users.component';
import { WorkInProgressComponent } from '../guest/work-in-progress/work-in-progress.component';
import { AlbumsComponent } from '../guest/albums/albums.component';
import { PlaylistsComponent } from '../guest/playlists/playlists.component';
import { TracksComponent } from '../guest/tracks/tracks.component';
import { TPsComponent } from '../guest/tps/tps.component';
import { GuestRoutingModule } from './guest-routing.module';
import { FormsModule } from '@angular/forms';
import { AlbumtracksComponent } from './albums/albumtracks/albumtracks.component';
import { PlaylisttracksComponent } from './playlists/playlisttracks/playlisttracks.component';

@NgModule({
  declarations: [GuestDashboardComponent, UsersComponent, WorkInProgressComponent, AlbumsComponent, TracksComponent, PlaylistsComponent, TPsComponent, AlbumtracksComponent, PlaylisttracksComponent],
  imports: [
    CommonModule,
    GuestRoutingModule,
    FormsModule
  ]
})
export class GuestModule { }
