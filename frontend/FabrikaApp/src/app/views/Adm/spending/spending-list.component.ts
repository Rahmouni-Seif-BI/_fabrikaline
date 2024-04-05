import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { GridComponent, ToolbarItems } from '@syncfusion/ej2-angular-grids';
import { SpendingControllerService } from './../../../../../libs/openapi/src/api/spendingController.service';
import { extraConfig } from './../../../config/extraConfig';
import { loadCldr, setCulture, setCurrencyCode, L10n } from '@syncfusion/ej2-base';
import numbers from './../../../cldr-data/numbers.json';
import currencies from './../../../cldr-data/currencies.json';
import { ILoadedEventArgs, ChartTheme, IAccPointRenderEventArgs, IAccLoadedEventArgs, AccumulationTheme, ChartAllModule, AccumulationChartAllModule } from '@syncfusion/ej2-angular-charts';
import { Purpose } from './../../../../../libs/openapi/src/model/purpose';
import { DashboardControllerService, LabelValueObject } from 'libs/openapi/src';



@Component({
  selector: 'app-spending-list',
  templateUrl: './spending-list.component.html',
  styleUrls: ['./spending-list.component.css'],

})
export class SpendingListComponent implements OnInit {
  public toolbarOptions?: ToolbarItems[];
  format: any;
  @ViewChild('grid') public grid!: GridComponent;
  chartDoughnutData : any;

  constructor(private route: Router, private service: SpendingControllerService, private dashboardControllerService: DashboardControllerService) { }
  ngOnInit(): void {
    loadCldr(currencies, numbers,);
    setCulture('tr');
    setCurrencyCode('TND');

    this.load();
    this.format = extraConfig.formatoptions;
  }

  load() {
    this.toolbarOptions = ['Search'];
    this.service.getAllSpendings().subscribe((data: any[]) => {

      this.grid.dataSource = data;

   
     

    });
  }

  delete() {
    if (this.grid.getSelectedRecords().length != 1) {
      alert('Sélectionner une ligne!');
    }
    else {
      let selectedrecord: any = this.grid.getSelectedRecords()[0]; // get the selected records.
      this.service.deleteSpending(selectedrecord['id']).subscribe((data: any) => {
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
    var routerPath = `/Adm/SpendingForm`;
    this.route.navigateByUrl(routerPath, navigationExtras);
  }
}
