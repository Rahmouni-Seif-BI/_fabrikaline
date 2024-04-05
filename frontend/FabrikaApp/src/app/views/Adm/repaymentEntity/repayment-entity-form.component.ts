import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { loadCldr, setCulture, setCurrencyCode, L10n } from '@syncfusion/ej2-base';
import numbers from '../../../cldr-data/numbers.json';
import currencies from '../../../cldr-data/currencies.json';
import { extraConfig } from '../../../config/extraConfig';
import { AccountControllerService } from '../../../../../libs/openapi/src/api/accountController.service';
import { PurposeControllerService } from '../../../../../libs/openapi/src/api/purposeController.service';
import { RepaymentEntity } from '../../../../../libs/openapi/src/model/repaymentEntity';
import { MaskedDateTimeService } from '@syncfusion/ej2-angular-calendars';
import { DatePipe } from '@angular/common';
import { RepaymentEntityControllerService } from './../../../../../libs/openapi/src/api/repaymentEntityController.service';

@Component({
  selector: 'app-repayment-entity-form',
  templateUrl: './repayment-entity-form.component.html',
  styleUrls: ['./repayment-entity-form.component.css'],
  providers: [MaskedDateTimeService],

})
export class RepaymentEntityFormComponent implements OnInit {

  object: any = {};
  id: any;
  public enableMaskSupport: boolean = true;
  public dateFormat: string = "yyyy-MM-dd";

  purposeList: any[] = [];
  repaymentStatusList: any[] = [];
  accountList: any[] = [];

  // Creating a new instance of RepaymentEntity
  newItem: RepaymentEntity = {
    amountRepaid: 0,
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
    repaymentDate: undefined
  };
  format: any;
  
  constructor(private route: Router,private _service: RepaymentEntityControllerService, private accountService: AccountControllerService, private purposeService: PurposeControllerService) { }

  ngOnInit() {
    this.format = extraConfig.formatoptions;

    loadCldr( currencies,  numbers,  );
    setCulture('tr');
    setCurrencyCode('TND');
    this.id = history.state.id;
    this.getRepaymentStatusList();
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

  getRepaymentStatusList() {
    // this.repaymentStatusService.getAllRepaymentStatus().subscribe((res: any) => {
    //   if (res != null) {
    //     this.repaymentStatusList = res;
    //   } else {
    //     alert("Something went wrong!")
    //   }
    // });
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

  selectRepaymentStatusItem(selectedItem: any) {
    this.object.repaymentStatus = selectedItem;
  }



  selectDebitorAccount(selectedItem: any) {
    this.object.debtorAccount = selectedItem;
  }

  selecCreditortAccount(selectedItem: any) {
    this.object.creditorAccount = selectedItem;
  }

  save(object: any) {
    this._service.saveRepaymentEntity_1(this.object.creditorAccount.id, this.object.debtorAccount.id, object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/RepaymentEntityList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load() {
    this._service.loadRepaymentEntity(this.id).subscribe((res: any) => {
      this.object = res;
    });
  }

  cancel() {
    this.route.navigate(['/Adm/RepaymentEntityList'])
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
