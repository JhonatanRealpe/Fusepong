import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CambioEstadoI } from 'src/app/modelos/cambioestado.interface';
import { IdNombreI } from 'src/app/modelos/idnombre.interface';
import { TickectI } from 'src/app/modelos/ticket.interface';
import { ApiService } from 'src/app/servicios/api/api.service';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  tickets:TickectI[];
  estados:IdNombreI[];
  cambioEstado:CambioEstadoI;

  constructor(private api:ApiService,private activerouter:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    let idHistoriaUsuario:any = this.activerouter.snapshot.paramMap.get('id');
    this.api.getTicket(idHistoriaUsuario).subscribe(data=>{
      this.tickets = data;
    });
    this.api.getEstado(0).subscribe(data=>{
      this.estados = data;
    });
  }

  verDetalleTickets(id){
    this.router.navigate(['detalleticket',id]);
  }

  onChange(value,idTickect){
    let idHistoriaUsuario:any = this.activerouter.snapshot.paramMap.get('id');
    this.router.navigate(['cambioestado',idTickect,value,idHistoriaUsuario]);
  }

}
