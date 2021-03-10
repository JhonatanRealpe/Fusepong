import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { LoginI } from 'src/app/modelos/login.interface';
import { ResponseI } from 'src/app/modelos/response.interface';
import { IdNombreI } from 'src/app/modelos/idnombre.interface';
import { TickectI } from 'src/app/modelos/ticket.interface';
import { EmpresaI } from 'src/app/modelos/empresa.interface';
import { CambioEstadoI } from 'src/app/modelos/cambioestado.interface';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  url: string ="http://localhost:8080/api/"

  constructor(private http: HttpClient) { }

  loginByEmail(form:LoginI):Observable<ResponseI>{
    let dir = this.url + "usuario/login";
    return this.http.post<ResponseI>(dir,form)
  }

  registro(form:ResponseI):Observable<number>{
    let dir = this.url + "usuario/insert";
    return this.http.post<number>(dir,form)
  }

  cambioEstado(form:CambioEstadoI):Observable<number>{
    let dir = this.url + "maestros/cambioestado";
    return this.http.post<number>(dir,form)
  }

  getEmpresas():Observable<EmpresaI[]>{
    let dir = this.url + "maestros/empresas";
    return this.http.get<EmpresaI[]>(dir)
  }

  getProyectos(idEmpresa:number):Observable<IdNombreI[]>{
    let dir = this.url + "maestros/proyecto/"+idEmpresa;
    return this.http.get<IdNombreI[]>(dir)
  }

  getHistoriaUsuario(idProyecto:number):Observable<IdNombreI[]>{
    let dir = this.url + "maestros/historiausuario/"+idProyecto;
    return this.http.get<IdNombreI[]>(dir)
  }

  getTicket(idHistoriaUsuario:number):Observable<TickectI[]>{
    let dir = this.url + "maestros/ticket/"+idHistoriaUsuario;
    return this.http.get<TickectI[]>(dir)
  }

  getEstado(idEstado:any):Observable<IdNombreI[]>{
    let dir = this.url + "maestros/estado/"+idEstado;
    return this.http.get<IdNombreI[]>(dir)
  }

}
