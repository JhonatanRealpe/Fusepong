import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { ApiService } from 'src/app/servicios/api/api.service';
import { ActivatedRoute, Router } from "@angular/router";
import { CambioEstadoI } from 'src/app/modelos/cambioestado.interface';

@Component({
  selector: 'app-cambioestado',
  templateUrl: './cambioestado.component.html',
  styleUrls: ['./cambioestado.component.css']
})
export class CambioestadoComponent implements OnInit {

  cambioEstado:CambioEstadoI;
  cambioForm = new FormGroup({
    comentario: new FormControl('',Validators.required),
  })

  constructor(private api:ApiService,private activerouter:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
  }

  errorStatus:boolean=false;
  errorMsj:any="El comentario es requerido";
  onCambioestado(form){
    this.errorStatus=this.cambioForm.invalid;
    if(!this.errorStatus){
      let idTickect:any = this.activerouter.snapshot.paramMap.get('idTicket');
      let idEstado:any = this.activerouter.snapshot.paramMap.get('idEstado');
      let idHistoriaUsuario:any = this.activerouter.snapshot.paramMap.get('idHU');
      this.cambioEstado = {"idTickect":idTickect,"idEstado":idEstado, "comentario":form.comentario};
      this.api.cambioEstado(this.cambioEstado).subscribe(data=>{
        if(data>0){
          this.router.navigate(['ticket',idHistoriaUsuario]);
        }else{
          this.errorStatus = true;
          this.errorMsj ="Error, en el servidor al intertar realizar cambio de estado!!! "
        }
        
    })
    }
    
  }

}
