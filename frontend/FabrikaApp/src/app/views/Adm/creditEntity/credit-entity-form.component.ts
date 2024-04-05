import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { loadCldr, setCulture, setCurrencyCode, L10n } from '@syncfusion/ej2-base';
import numbers from '../../../cldr-data/numbers.json';
import currencies from '../../../cldr-data/currencies.json';
import { extraConfig } from '../../../config/extraConfig';
import { CreditEntityControllerService } from '../../../../../libs/openapi/src/api/creditEntityController.service';
import { AccountControllerService } from './../../../../../libs/openapi/src/api/accountController.service';
import { PurposeControllerService } from './../../../../../libs/openapi/src/api/purposeController.service';
import { CreditStatusControllerService } from './../../../../../libs/openapi/src/api/creditStatusController.service';
import { CreditEntity } from '../../../../../libs/openapi/src/model/creditEntity';
import { MaskedDateTimeService } from '@syncfusion/ej2-angular-calendars';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-credit-entity-form',
  templateUrl: './credit-entity-form.component.html',
  styleUrls: ['./credit-entity-form.component.css'],
  providers: [MaskedDateTimeService],

})
export class CreditEntityFormComponent implements OnInit {

  object: any = {};
  id: any;
  public enableMaskSupport: boolean = true;
  public dateFormat: string = "yyyy-MM-dd";

  purposeList: any[] = [];
  creditStatusList: any[] = [];
  accountList: any[] = [];

  // Creating a new instance of CreditEntity
  newItem: CreditEntity = {
    amount: 0,
    creditorAccount : {
      id: undefined,
      code: undefined,
      description: undefined
    },
    debtorAccount: {
      id: undefined,
      code: undefined,
      description: undefined
    },
    endDate: undefined,//this.datePipe.transform(new Date(), 'dd/MM/yyyy')?.toString(),
    startDate: undefined,//this.datePipe.transform(new Date(), 'dd/MM/yyyy')?.toString(),
    interestRate: 0,
  };
  format: any;
  
  constructor(private route: Router,private _service: CreditEntityControllerService, private accountService: AccountControllerService, private purposeService: PurposeControllerService, private creditStatusService: CreditStatusControllerService) { }

  ngOnInit() {
    this.format = extraConfig.formatoptions;

    loadCldr( currencies,  numbers,  );
    setCulture('tr');
    setCurrencyCode('TND');
    this.id = history.state.id;
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



  selectDebitorAccount(selectedItem: any) {
    this.object.debtorAccount = selectedItem;
  }

  selecCreditortAccount(selectedItem: any) {
    this.object.creditorAccount = selectedItem;
  }

  save(object: any) {
    this._service.saveCreditEntity(this.object.creditorAccount.id, this.object.debtorAccount.id, object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/CreditEntityList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load() {
    this._service.loadCreditEntity(this.id).subscribe((res: any) => {
      this.object = res;
    });
  }

  cancel() {
    this.route.navigate(['/Adm/CreditEntityList'])
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


