import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DetalleTickectI } from 'src/app/modelos/detalleticket.interface';
import { ApiService } from 'src/app/servicios/api/api.service';

@Component({
  selector: 'app-detalleticket',
  templateUrl: './detalleticket.component.html',
  styleUrls: ['./detalleticket.component.css']
})
export class DetalleticketComponent implements OnInit {

  detalleTicket: DetalleTickectI[];

  constructor(private api:ApiService,private activerouter:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    let idTicket:any = this.activerouter.snapshot.paramMap.get('id');
    this.api.getDetalleTicket(idTicket).subscribe(data=>{
      this.detalleTicket = data;
    });
  }

}
