import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { GridComponent, ToolbarItems } from '@syncfusion/ej2-angular-grids';
import { extraConfig } from '../../../config/extraConfig';
import { loadCldr, setCulture, setCurrencyCode, L10n } from '@syncfusion/ej2-base';
import numbers from '../../../cldr-data/numbers.json';
import currencies from '../../../cldr-data/currencies.json';
import { RepaymentEntityControllerService } from '../../../../../libs/openapi/src/api/repaymentEntityController.service';

@Component({
  selector: 'app-repayment-entity-list',
  templateUrl: './repayment-entity-list.component.html',
  styleUrls: ['./repayment-entity-list.component.css']
})
export class RepaymentEntityListComponent implements OnInit {
  public toolbarOptions?: ToolbarItems[];
  format:any;
  constructor(private route: Router, private service: RepaymentEntityControllerService) { }
  ngOnInit(): void {
    loadCldr( currencies,  numbers,  );
    setCulture('tr');
    setCurrencyCode('TND');

    this.load();
    this.format = extraConfig.formatoptions;
  }

  @ViewChild('grid') public grid!: GridComponent;
  
  load() {
    this.toolbarOptions = ['Search'];
    this.service.getAllRepaymentEntitiesDTO().subscribe((data: any[]) => {
      
      this.grid.dataSource = data;
    });
  }
  


  delete() {
    if (this.grid.getSelectedRecords().length != 1) {
      alert('Sélectionner une ligne!');
    }
    else {
      let selectedrecord: any = this.grid.getSelectedRecords()[0]; // get the selected records.
      this.service.deleteRepaymentEntity(selectedrecord['id']).subscribe((data: any) => {
        this.load()
      });
    }
  }


  public onDoubleClick(event: any): void {
    this.edit(event.rowData);
  }

  modify() {
    if (this.grid.getSelectedRecords().length != 1) {
      alert('Sélectionner une ligne!');
    }
    else {
      let selectedrecord: any = this.grid.getSelectedRecords()[0]; 
      this.edit(selectedrecord);
    }
  }

  public edit(selectedrecord: any) {

    const navigationExtras: NavigationExtras = {
      state: {
        id: selectedrecord.id,
      }
    };
    var routerPath = `/Adm/RepaymentEntityForm`;
    this.route.navigateByUrl(routerPath, navigationExtras);
  }
}
