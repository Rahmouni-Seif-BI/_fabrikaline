import { Component, OnInit } from '@angular/core';
import { DashboardControllerService, LabelValueObject } from 'libs/openapi/src';

@Component({
  selector: 'app-stat',
  templateUrl: './stat.component.html',
  styleUrls: ['./stat.component.css']
})
export class StatComponent implements OnInit {
  chartDoughnutData: any;
  totalDepositeByAccountData: any;
  totalconsumedByAccountData: any;
  totalResteByAccountData: any;

  constructor(public dashboardControllerService: DashboardControllerService) { }

  ngOnInit() {
    this.getSpendingsByPurpose();
    this.getTotalDepositeByAccountData();
    this.getTotalResteByAccountData();
    this.getTotalConsumedByAccountData();
  }


  getSpendingsByPurpose() {
    this.dashboardControllerService.getSpendingsByPurpose().subscribe((dashboarData: LabelValueObject[]) => {
      let res = dashboarData;
      let labels: String[] = [];
      let values: number[] = [];

      for (let item of res) {
        if (item.label) { // Check if label is defined
          labels.push(item.label);
        }
        if (item.value) {
          values.push(item.value);
        }

      }
      this.chartDoughnutData = {
        labels: labels,
        datasets: [
          {
            backgroundColor: ['#E46651', '#00D8FF', '#DD1B16', '#000000', '#7C9200', '#1F008D', '#3D003A'],
            data: values
          }
        ]
      };
    });

  }



  getTotalConsumedByAccountData() {
    this.dashboardControllerService.getSpendingsByAccount1().subscribe((dashboarData: LabelValueObject[]) => {
      let res = dashboarData;
      let labels: String[] = [];
      let values: number[] = [];

      for (let item of res) {
        if (item.label) { // Check if label is defined
          labels.push(item.label);
        }
        if (item.value) {
          values.push(item.value);
        }

      }
      this.totalconsumedByAccountData = {
        labels: labels,
        datasets: [
          {
            backgroundColor: ['#E46651', '#00D8FF', '#DD1B16', '#000000', '#7C9200', '#1F008D', '#3D003A'],
            data: values
          }
        ]
      };
    });

  }



  getTotalResteByAccountData() {
    this.dashboardControllerService.getRestAmountByAccount().subscribe((dashboarData: LabelValueObject[]) => {
      let res = dashboarData;
      let labels: String[] = [];
      let values: number[] = [];

      for (let item of res) {
        if (item.label) { // Check if label is defined
          labels.push(item.label);
        }
        if (item.value) {
          values.push(item.value);
        }

      }
      this.totalResteByAccountData = {
        labels: labels,
        datasets: [
          {
            backgroundColor: ['#E46651', '#00D8FF', '#DD1B16', '#000000', '#7C9200', '#1F008D', '#3D003A'],
            data: values
          }
        ]
      };
    });

  }




  getTotalDepositeByAccountData() {
    this.dashboardControllerService.getDepositeByAccount().subscribe((dashboarData: LabelValueObject[]) => {
      let res = dashboarData;
      let labels: String[] = [];
      let values: number[] = [];

      for (let item of res) {
        if (item.label) { // Check if label is defined
          labels.push(item.label);
        }
        if (item.value) {
          values.push(item.value);
        }

      }
      this.totalDepositeByAccountData = {
        labels: labels,
        datasets: [
          {
            backgroundColor: ['#E46651', '#00D8FF', '#DD1B16', '#000000', '#7C9200', '#1F008D', '#3D003A'],
            data: values
          }
        ]
      };
    });

  }

}
