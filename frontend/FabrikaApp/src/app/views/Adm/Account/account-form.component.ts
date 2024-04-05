import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AccountControllerService, DepositeControllerService, SpendingControllerService } from 'libs/openapi/src';
import { GridComponent } from '@syncfusion/ej2-angular-grids';
import { loadCldr, setCulture, setCurrencyCode, L10n } from '@syncfusion/ej2-base';
import numbers from './../../../cldr-data/numbers.json';
import currencies from './../../../cldr-data/currencies.json';
import { extraConfig } from 'src/app/config/extraConfig';
import { ILoadedEventArgs, ChartTheme, IAccPointRenderEventArgs, IAccLoadedEventArgs, AccumulationTheme, ChartAllModule, AccumulationChartAllModule } from '@syncfusion/ej2-angular-charts';


@Component({
  selector: 'app-account-form',
  templateUrl: './account-form.component.html',
  styleUrls: ['./account-form.component.css']
})
export class AccountFormComponent implements OnInit {
  object: any = {}; // Initialize object with empty object
  @ViewChild('gridSpending') public gridSpending!: GridComponent;
  @ViewChild('gridSpending2') public gridSpending2!: GridComponent;
  @ViewChild('gridDeposite') public gridDeposite!: GridComponent;
  @ViewChild('gridDeposite2') public gridDeposite2!: GridComponent;
  @ViewChild('gridCredit') public gridCredit!: GridComponent;
  @ViewChild('gridRepayment') public gridRepayment!: GridComponent;

  
  format: any;
  hidden: boolean = true;
  constructor(private route: Router, private spendingControllerService: SpendingControllerService,  private accountControllerService: AccountControllerService
    , private depositeControllerService: DepositeControllerService) { }
  id: any;

  ngOnInit() {
    this.format = extraConfig.formatoptions;

    loadCldr( currencies,  numbers,  );
    setCulture('tr');
    setCurrencyCode('TND');

    this.id = history.state.id;
    if (this.id != null) {
      this.object.id = this.id;
      this.load();


      this.loadDeposite();
      this.getSpendingsByAccount();
      this.getDepositesByAccount();
      this.getCreditGiven();
      this.getRepayment();
    }
  }

  //Initializing Primary X Axis
  public spLineAreaprimaryXAxis: Object = {
    valueType: 'Category',
    majorGridLines: { width: 0 },
    majorTickLines: { width: 0 },
    edgeLabelPlacement: 'Shift',
    lableStyle: { size: '11px' }
  };
  //Initializing Primary Y Axis
  public spLineAreaprimaryYAxis: Object = {
    labelFormat: '${value}',
    lineStyle: { width: 0 },
    maximum: 10000,
    minimum: 0,
    majorTickLines: { width: 0 },
    lableStyle: { size: '11px' },
    textStyle: { size: '13px' }
  };

  public spLineLegendSettings: Object = {
    enableHighlight: true,
  }

  public spLineAreatooltipSettings: Object = {
    enable: true,
    shared: true,
    enableMarker: false
  };
  public spLineAreaBorder: Object = {
    width: 2.75,
    color:'#2485fa'
  };
  public spLineAreaBorder1: Object = {
    width: 2.75,
    color:'#FEC200'
  };

  public chartArea: Object = {
    border: { width: 0,},
  };

    //Spline Area
  
    public spLineAreaData: Object[] = [];
 public spLineAreaData2: Object[] = [
     { Period : "Jan", Percentage : 6400,},
     { Period : "Feb", Percentage : 5300 },
     { Period : "Mar", Percentage : 4900 },
    //  { Period : "Apr", Percentage : 5300 },
    //  { Period : "May", Percentage : 4200 },
    //  { Period : "Jun", Percentage : 6500 },
    //  { Period : "Jul", Percentage : 7900 },
    //  { Period : "Aug", Percentage : 3800 },
    //  { Period : "Sep", Percentage : 6800 },
    //  { Period : "Oct", Percentage : 3400 },
    //  { Period : "Nov", Percentage : 6400 },
    //  { Period : "Dec", Percentage : 6800 }
 ];

 
 public spLineAreaFill: string = '#2485fa'
 public spLineAreaFill1: string = '#FEC200'

 public load1(args: ILoadedEventArgs ): void {
  let selectedTheme: string = location.hash.split('/')[1];
  selectedTheme = selectedTheme ? selectedTheme : 'Material';
  args.chart.theme = <ChartTheme>(selectedTheme.charAt(0).toUpperCase() + selectedTheme.slice(1)).replace(/-dark/i, "Dark").replace(/contrast/i, 'Contrast');
  args.chart.series[0].fill = 'url(#' +'gradient-chart)';
  args.chart.series[1].fill = 'url(#' +'gradient-chart1)';
};







  getRepayment() {
    this.accountControllerService.getRepaymentsReceivedByAccountAccount(this.id).subscribe((data: any[]) => {
      this.gridRepayment.dataSource = data;
    });
  }

  getCreditGiven() {
    this.accountControllerService.getCreditsGivenByAccountAccount(this.id).subscribe((data: any[]) => {
      this.gridCredit.dataSource = data;
    });
  }


  getSpendingsByAccount() {
    this.spendingControllerService.getSpendingsByAccount(this.id).subscribe((data: any[]) => {
      this.gridSpending.dataSource = data;
      this.gridSpending2.dataSource = data;
    });
  }

  getDepositesByAccount() {
    this.depositeControllerService.getDepositesByAccount(this.id).subscribe((data: any[]) => {
      this.gridDeposite.dataSource = data;
      this.gridDeposite2.dataSource = data;
    });
  }

  save(object: any) {
    this.toggleToast();
    this.accountControllerService.saveAccount(object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/AccountList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load(){
    this.accountControllerService.loadAccount(this.id).subscribe((res: any) => {   
      this.object = res;
      if (this.object.code == "IN") {
        this.hidden = false
         //Spline Area
  
    this.spLineAreaData = [
      { Period : "Jan", Percentage : this.object.calculatedAmountconsumed},
      { Period : "Feb", Percentage : 1222 },
      { Period : "Mar", Percentage : 8100 },
      // { Period : "Apr", Percentage : 5900 },
      // { Period : "May", Percentage : 8900 },
      // { Period : "Jun", Percentage : 7200 },
      // { Period : "Jul", Percentage : 4300 },
      // { Period : "Aug", Percentage : 4600 },
      // { Period : "Sep", Percentage : 5500 },
      // { Period : "Oct", Percentage : 6350 },
      // { Period : "Nov", Percentage : 5700 },
      // { Period : "Dec", Percentage : 8000 }
 ];
      }
    });
  }
  
  loadDeposite(){
    // this._service.load15(this.id).subscribe((res: any) => {   
    //   this.object = res;
    // });
  }

  cancel() {
    this.route.navigate(['/Adm/AccountList'])
  }

  position = 'top-center';
  visible = false;
  percentage = 0;

  toggleToast() {
    this.visible = !this.visible;
  }

  onVisibleChange($event: boolean) {
    this.visible = $event;
    this.percentage = !this.visible ? 0 : this.percentage;
  }

  onTimerChange($event: number) {
    this.percentage = $event * 50;
  }
}
