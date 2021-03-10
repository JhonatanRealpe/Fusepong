import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/servicios/api/api.service';
import { Router } from "@angular/router";
import { IdNombreI } from 'src/app/modelos/idnombre.interface';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  proyectos:IdNombreI[];

  constructor(private api:ApiService, private router:Router) { }

  ngOnInit(): void {
    let idEmpresa:any = localStorage.getItem('idE');
    this.api.getProyectos(idEmpresa).subscribe(data=>{
      this.proyectos = data;
    });
  }

  verHistoriaUsuario(id){
    this.router.navigate(['historiausuario',id]);
  }

}
