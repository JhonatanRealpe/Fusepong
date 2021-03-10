import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { ApiService } from 'src/app/servicios/api/api.service';
import { Router } from "@angular/router";
import { ResponseI } from 'src/app/modelos/response.interface';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = new FormGroup({
    email: new FormControl('',Validators.required),
    contrasena: new FormControl('', Validators.required)
  })

  constructor(private api:ApiService, private router:Router) { }

  ngOnInit(): void {
    this.checkLocalStorage();
  }

  checkLocalStorage(){
    if(localStorage.getItem('idE')){
      this.router.navigate(['dashboard']);
    }
  }

  errorStatus:boolean=false;
  errorMsj:any="";
  onLogin(form){
    this.api.loginByEmail(form).subscribe(data=>{
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
  }

  registro(){
    this.router.navigate(['registro']);
  }

}
