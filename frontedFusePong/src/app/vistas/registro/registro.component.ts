import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { ApiService } from 'src/app/servicios/api/api.service';
import { Router } from "@angular/router";
import { EmpresaI } from 'src/app/modelos/empresa.interface';
import { LoginI } from 'src/app/modelos/login.interface';
import { ResponseI } from 'src/app/modelos/response.interface';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  registroForm = new FormGroup({
    nombres: new FormControl('',Validators.required),
    apellidos: new FormControl('',Validators.required),
    telefono: new FormControl('',Validators.required),
    email: new FormControl('',Validators.required),
    contrasena: new FormControl('', Validators.required),
    idEmpresa: new FormControl('', Validators.required)
  })
  empresas:EmpresaI[];
  login:LoginI;

  constructor(private api:ApiService, private router:Router) { }


  ngOnInit(): void {
    this.api.getEmpresas().subscribe(data=>{
      this.empresas = data;
    });
    
  }

  errorStatus:boolean=false;
  errorMsj:any="Datos incompletos";
  onRegistro(form){
    this.errorStatus=this.registroForm.invalid;
    if(!this.errorStatus){
      this.login = {"email":form.email,"contrasena":form.contrasena};
      
      this.api.registro(form).subscribe(data=>{
        if(data>0){
          this.api.loginByEmail(this.login).subscribe(data=>{
            if(Object.keys(data).length > 0){
              let dataResponse: ResponseI = data;
              localStorage.setItem('nombre',dataResponse[0].nombres);
              localStorage.setItem('idE',dataResponse[0].idEmpresa);
              localStorage.setItem('empresa',dataResponse[0].nombreEmpresa);
              this.errorStatus = false;
              this.router.navigate(['dashboard']);
            }else{
              this.errorStatus = true;
              this.errorMsj ="Datos incorrectos, email o password no coinciden!!! "
            }
          })
        }else{
          this.errorStatus = true;
          this.errorMsj ="Error, en el servidor al intertar registrar esos datos!!! "
        }
        
    })
      
    }
    

    
  }

}
