import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PurposeControllerService } from './../../../../../libs/openapi/src/api/purposeController.service';

@Component({
  selector: 'app-purpose-form',
  templateUrl: './purpose-form.component.html',
})
export class PurposeFormComponent implements OnInit {
  object: any = {}; // Initialize object with empty object

  constructor(private route: Router, private _service: PurposeControllerService) { }
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
    this._service.saveCreditEntity(object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/PurposeList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load(){
    this._service.load(this.id).subscribe((res: any) => {   
      this.object = res;
    });
  }

  cancel() {
    this.route.navigate(['/Adm/PurposeList'])
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