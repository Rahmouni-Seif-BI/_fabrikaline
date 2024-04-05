import { Component, OnInit } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { Deposite, AccountControllerService, DepositeControllerService } from 'libs/openapi/src';
import { loadCldr, setCulture, setCurrencyCode, L10n } from '@syncfusion/ej2-base';
import numbers from './../../../cldr-data/numbers.json';
import currencies from './../../../cldr-data/currencies.json';
@Component({
  selector: 'app-deposite-form',
  templateUrl: './deposite-form.component.html',
  styleUrls: ['./deposite-form.component.css']
})
export class DepositeFormComponent implements OnInit {

  object: any = {};
  id: any;

  accountList: any[] = [];

  // Creating a new instance of Item
  newItem: Deposite = {
    code: undefined,
    notes: undefined,
    amountToDeposite: 0,
    actionDate: undefined,
    account: {
      id: undefined,
      code: undefined,
      description: undefined
    },
  };
  
  constructor(private route: Router, private depositeControllerService: DepositeControllerService, private accountService: AccountControllerService) { }

  ngOnInit() {
    loadCldr( currencies,  numbers,  );
    setCulture('tr');
    setCurrencyCode('TND');
    this.id = history.state.id;
    this.getAccountList();

    if (this.id != null) {
      this.object.id = this.id;
      this.load();
    } else {
      this.object = this.newItem;
    }
  }

  getAccountList() {
    this.accountService.getAllAccounts().subscribe((res: any) => {
      if (res != null) {
        this.accountList = res;
      } else {
        alert("Something went wrong!")
      }
    });
  }



  selectAccount(selectedItem: any) {
    this.object.account = selectedItem;
  }

  save(object: any) {
    this.depositeControllerService.saveDeposite(this.object.account.id, object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/DepositeList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load() {
    this.depositeControllerService.loadDeposite(this.id).subscribe((res: any) => {
      this.object = res;
    });
  }

  cancel() {
    this.route.navigate(['/Adm/DepositeList'])
  }



  Attacher() {
    const navigationExtras: NavigationExtras = {
      state: {
        parentId: this.object.id
      }
    };
    this.route.navigate(['/Adm/AttachementList'], navigationExtras)
  }

}
