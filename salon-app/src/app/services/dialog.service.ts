import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from '../views/dialog/dialog/dialog.component';

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  constructor(
    private dialog: MatDialog
  ) { }

  openDialog(titleDialog: string, msg: string){
    return this.dialog.open(DialogComponent,{
      width: '390px',
      disableClose: true,
      data:{
        title: titleDialog,
        message: msg
      }
    })
  }
}
