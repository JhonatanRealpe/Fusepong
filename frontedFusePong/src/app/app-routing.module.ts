import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AgregarticketComponent } from './vistas/agregarticket/agregarticket.component';
import { CambioestadoComponent } from './vistas/cambioestado/cambioestado.component';
import { DashboardComponent } from './vistas/dashboard/dashboard.component';
import { DetalleticketComponent } from './vistas/detalleticket/detalleticket.component';
import { HistoriausuarioComponent } from './vistas/historiausuario/historiausuario.component';
import { LoginComponent } from './vistas/login/login.component';
import { RegistroComponent } from './vistas/registro/registro.component';
import { TicketComponent } from './vistas/ticket/ticket.component';

const routes: Routes = [
  {path:'', redirectTo:'login', pathMatch:'full'},
  {path:'login', component:LoginComponent},
  {path:'dashboard', component:DashboardComponent},
  {path:'registro', component:RegistroComponent},
  {path:'historiausuario/:id', component:HistoriausuarioComponent},
  {path:'ticket/:id', component:TicketComponent},
  {path:'detalleticket/:id', component:DetalleticketComponent},
  {path:'agregarticket/:id', component:AgregarticketComponent},
  {path:'cambioestado/:idTicket/:idEstado/:idHU', component:CambioestadoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [LoginComponent,DashboardComponent,RegistroComponent]
