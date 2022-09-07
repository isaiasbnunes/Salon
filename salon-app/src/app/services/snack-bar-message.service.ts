import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class SnackBarMessageService {

  constructor(
    private snack: MatSnackBar
  ) { }

  message(msg: string):void{
    this.snack.open(msg,'ok',{
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }
}
