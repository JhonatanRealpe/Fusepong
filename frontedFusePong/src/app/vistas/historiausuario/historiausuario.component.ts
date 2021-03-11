import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/servicios/api/api.service';
import { Router, ActivatedRoute } from "@angular/router";
import { IdNombreI } from 'src/app/modelos/idnombre.interface';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { ModalManager } from 'ngb-modal';

@Component({
  selector: 'app-historiausuario',
  templateUrl: './historiausuario.component.html',
  styleUrls: ['./historiausuario.component.css']
})
export class HistoriausuarioComponent implements OnInit {

  historiasUsuario:IdNombreI[];
  titulo:any='Crear nueva historia de usuario';
  proyectoid:any=0;
  idHUsuario:any=0;
  opction:any=0;
  errorStatus:boolean=false;
  errorMsj:any="Campo Requerido";
  private modalRef;
  hUsuario:IdNombreI;

  addForm = new FormGroup({
    nombre: new FormControl('',Validators.required)
  })

  constructor(
      private api:ApiService
    , private activerouter:ActivatedRoute
    , private router:Router
    , private modalService: ModalManager
    ) { }

  ngOnInit(): void {
    this.init();
  }

  init(){
    this.proyectoid = this.activerouter.snapshot.paramMap.get('id');
    this.api.getHistoriaUsuario(this.proyectoid).subscribe(data=>{
      this.historiasUsuario = data;
    });
  }

  verTickets(id){
    this.router.navigate(['ticket',id]);
  }

  openModal(myModal,opction,name,idhUsuario){
    this.titulo = opction==1?this.titulo:'Crear nuevo Ticket para '+name;
    this.errorMsj ="Campo Requerido";
    this.opction = opction;
    this.idHUsuario = idhUsuario;
    this.addForm.setValue({nombre:''});
    this.modalRef = this.modalService.open(myModal, {
        size: "md",
        modalClass: 'mymodal',
        hideCloseButton: false,
        centered: opction==1?false:true,
        backdrop: true,
        animation: true,
        keyboard: false,
        closeOnOutsideClick: true,
        backdropClass: "modal-backdrop"
    })
}
closeModal(){
    this.modalService.close(this.modalRef);
    //or this.modalRef.close();
}

addModal(form){
  this.errorStatus=this.addForm.invalid;
    if(!this.errorStatus){
      if(this.opction == 1){
        this.hUsuario = {"id":this.proyectoid,"nombre":form.nombre,"estado":""};
        this.api.addhitoriausuario(this.hUsuario).subscribe(data=>{
          if(data>0){
            //mensaje de exito
            this.init();
          }else{
            this.errorStatus = true;
            this.errorMsj ="Error, en el servidor al intertar realizar cambio de estado!!! "
          }
          
        })
      }else if(this.opction == 2){
        this.hUsuario = {"id":this.idHUsuario,"nombre":form.nombre,"estado":""};
        this.api.addticket(this.hUsuario).subscribe(data=>{
          if(data>0){
            //mensaje de exito
            this.init();
          }else{
            this.errorStatus = true;
            this.errorMsj ="Error, en el servidor al intertar realizar cambio de estado!!! "
          }
          
        })
      }
      this.closeModal(); 
    }
}

}
