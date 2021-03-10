import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/servicios/api/api.service';
import { Router, ActivatedRoute } from "@angular/router";
import { IdNombreI } from 'src/app/modelos/idnombre.interface';

@Component({
  selector: 'app-historiausuario',
  templateUrl: './historiausuario.component.html',
  styleUrls: ['./historiausuario.component.css']
})
export class HistoriausuarioComponent implements OnInit {

  historiasUsuario:IdNombreI[];

  constructor(private api:ApiService,private activerouter:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    let proyectoid:any = this.activerouter.snapshot.paramMap.get('id');
    this.api.getHistoriaUsuario(proyectoid).subscribe(data=>{
      this.historiasUsuario = data;
    });
  }

  verTickets(id){
    this.router.navigate(['ticket',id]);
  }

}
