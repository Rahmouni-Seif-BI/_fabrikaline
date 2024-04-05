import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { AccountControllerService, CreditStatusControllerService, PurposeControllerService, Spending, SpendingControllerService } from 'libs/openapi/src';
import { loadCldr, setCulture, setCurrencyCode, L10n } from '@syncfusion/ej2-base';
import numbers from './../../../cldr-data/numbers.json';
import currencies from './../../../cldr-data/currencies.json';
import { extraConfig } from 'src/app/config/extraConfig';

@Component({
  selector: 'app-spending-form',
  templateUrl: './spending-form.component.html',
  styleUrls: ['./spending-form.component.css']
})
export class SpendingFormComponent implements OnInit {

  object: any = {};
  id: any;

  purposeList: any[] = [];
  creditStatusList: any[] = [];
  accountList: any[] = [];

  // Creating a new instance of Item
  newItem: Spending = {
    code: undefined,
    notes: undefined,
    amountToSpend: 0,
    actionDate: undefined,
    purpose: {
      id: undefined,
      code: undefined,
      description: undefined
    },
    creditStatus: {
      id: undefined,
      code: undefined,
      description: undefined
    },
    account: {
      id: undefined,
      code: undefined,
      description: undefined
    },
  };
  format: any;
  
  constructor(private route: Router,private _service: SpendingControllerService,private accountService: AccountControllerService, private purposeService: PurposeControllerService, private creditStatusService: CreditStatusControllerService) { }

  ngOnInit() {
    this.format = extraConfig.formatoptions;

    loadCldr( currencies,  numbers,  );
    setCulture('tr');
    setCurrencyCode('TND');
    this.id = history.state.id;
    this.getPurposeList();
    this.getCreditStatusList();
    this.getAccountList();

    if (this.id != null) {
      this.object.id = this.id;
      this.load();
    } else {
      this.object = this.newItem;
    }
  }


  getPurposeList() {
    this.purposeService.getAll().subscribe((res: any) => {
      if (res != null) {
        this.purposeList = res;
      } else {
        alert("Something went wrong!")
      }
    });
  }

  getCreditStatusList() {
    this.creditStatusService.getAllCreditStatus().subscribe((res: any) => {
      if (res != null) {
        this.creditStatusList = res;
      } else {
        alert("Something went wrong!")
      }
    });
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
  selectPurpose(selectedItem: any) {
    this.object.purpose = selectedItem;
  }

  selectCreditStatusItem(selectedItem: any) {
    this.object.creditStatus = selectedItem;
  }

  selectAccount(selectedItem: any) {
    this.object.account = selectedItem;
  }

  save(object: any) {
    this._service.saveSpending(this.object.purpose.id,this.object.creditStatus.id, this.object.account.id, object).subscribe((res: any) => {
      
        this.route.navigate(['/Adm/SpendingList'])
     
    });
  }

  load() {
    this._service.loadSpending(this.id).subscribe((res: any) => {
      this.object = res;
    });
  }

  cancel() {
    this.route.navigate(['/Adm/SpendingList'])
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
