import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CreditStatusControllerService } from 'libs/openapi/src';

@Component({
  selector: 'app-credit-status-form',
  templateUrl: './credit-status-form.component.html',
  styleUrls: ['./credit-status-form.component.css']
})
export class CreditStatusFormComponent implements OnInit {

  object: any = {}; // Initialize object with empty object

  constructor(private route: Router, private _service: CreditStatusControllerService) { }
  id: any;

  ngOnInit() {
    this.id = history.state.id;
    if (this.id != null) {
      this.object.id = this.id;
      this.load();
    }
  }

  save(object: any) {
    this.toggleToast();
    this._service.saveCreditStatus(object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/CreditStatusList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load(){
    this._service.loadCreditStatus(this.id).subscribe((res: any) => {   
      this.object = res;
    });
  }

  cancel() {
    this.route.navigate(['/Adm/CreditStatusList'])
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
