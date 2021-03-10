import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './plantillas/header/header.component';
import { FooterComponent } from './plantillas/footer/footer.component';
import { LoginComponent } from './vistas/login/login.component';
import { DashboardComponent } from './vistas/dashboard/dashboard.component';
import { RegistroComponent } from './vistas/registro/registro.component';

import { ReactiveFormsModule, FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { HistoriausuarioComponent } from './vistas/historiausuario/historiausuario.component';
import { TicketComponent } from './vistas/ticket/ticket.component';
import { DetalleticketComponent } from './vistas/detalleticket/detalleticket.component';
import { CambioestadoComponent } from './vistas/cambioestado/cambioestado.component';
import { AgregarticketComponent } from './vistas/agregarticket/agregarticket.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    DashboardComponent,
    RegistroComponent,
    HistoriausuarioComponent,
    TicketComponent,
    DetalleticketComponent,
    CambioestadoComponent,
    AgregarticketComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule, 
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
