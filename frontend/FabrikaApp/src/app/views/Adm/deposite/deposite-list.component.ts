import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { GridComponent, ToolbarItems } from '@syncfusion/ej2-angular-grids';
import { DepositeControllerService } from 'libs/openapi/src';
import { loadCldr, setCulture, setCurrencyCode, L10n } from '@syncfusion/ej2-base';
import numbers from './../../../cldr-data/numbers.json';
import currencies from './../../../cldr-data/currencies.json';

@Component({
  selector: 'app-deposite-list',
  templateUrl: './deposite-list.component.html',
  styleUrls: ['./deposite-list.component.css']
})
export class DepositeListComponent implements OnInit {

  constructor(private route: Router, private depositeControllerService: DepositeControllerService) { }
  ngOnInit(): void {
    loadCldr( currencies,  numbers,  );
    setCulture('tr');
    setCurrencyCode('TND');
    this.load();
  }
  public toolbarOptions?: ToolbarItems[];

  @ViewChild('grid') public grid!: GridComponent;

  load() {
    this.toolbarOptions = ['Search'];
    this.depositeControllerService.getAllDeposites().subscribe((data: any[]) => {
      this.grid.dataSource = data;
    });
  }


  delete() {
    if (this.grid.getSelectedRecords().length != 1) {
      alert('Sélectionner une ligne!');
    }
    else {
      let selectedrecord: any = this.grid.getSelectedRecords()[0]; // get the selected records.
      this.depositeControllerService.deleteDeposite(selectedrecord['id']).subscribe((data: any) => {
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
    var routerPath = `/Adm/DepositeForm`;
    this.route.navigateByUrl(routerPath, navigationExtras);
  }
}
