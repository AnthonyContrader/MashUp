import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GuestDashboardComponent } from './guest-dashboard/guest-dashboard.component';

import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { AlbumsComponent } from './albums/albums.component';
import { PlaylistsComponent } from './playlists/playlists.component';
import { TracksComponent } from './tracks/tracks.component';
import { TPsComponent } from './tps/tps.component';
import { GuestLayoutComponent } from '../layout/guest-layout/guest-layout.component';
import { UsersComponent } from 'src/app/guest/users/users.component';
import { AlbumtracksComponent } from './albums/albumtracks/albumtracks.component';
import { PlaylisttracksComponent } from './playlists/playlisttracks/playlisttracks.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'guest-dashboard', component: GuestLayoutComponent, children:[
    { path: '', component: GuestDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent},
    { path: 'albums', component: AlbumsComponent},
    { path: 'playlists', component: PlaylistsComponent},
    { path: 'tracks', component: TracksComponent},
    { path: 'tps', component: TPsComponent },
    { path: 'albumtracks', component: AlbumtracksComponent },
    { path: 'playlisttracks', component: PlaylisttracksComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GuestRoutingModule { }