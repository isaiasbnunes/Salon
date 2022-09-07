import { SnackBarMessageService } from './../../../services/snack-bar-message.service';
import { DialogService } from './../../../services/dialog.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Customer } from 'src/app/models/customer';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[]  = [];

  displayedColumns: string[] = ['id', 'name', 'lastName', 'phone'];
  dataSource = new MatTableDataSource<Customer>(this.customers);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private router: Router,
    private serviceDialog: DialogService,
    private service: CustomerService,
    private snackBarMessageService: SnackBarMessageService,
  ) { }

  ngOnInit(): void {
    this.findAll();
  }

  navigateToCreate():void{
    this.router.navigate(['customer/create'])
  }

  private delete(id: any): void{
    this.service.delete(id).subscribe(
      r => this.onSuccessDelete()
    );
  }

  findAll():void{
    this.service.findAll().subscribe((resposta) => {
      this.customers = resposta;
      this.dataSource = new MatTableDataSource<Customer>(this.customers);
      this.dataSource.paginator = this.paginator;
    })
  }

  private onSuccessDelete():void{
    this.findAll();
    this.snackBarMessageService.message('Cliente deletado com sucesso!');
  }

  openDialog(id: any):void{
    this.serviceDialog.openDialog("Excluir cliente",
      "Tem certeza que deseja excluir o cliente selecionado?")
   .afterClosed().subscribe(r =>{
      if(r){
        this.delete(id);
      }
   });
  }
}
