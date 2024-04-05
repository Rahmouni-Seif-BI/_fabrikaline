import { RepaymentEntityFormComponent } from './repaymentEntity/repayment-entity-form.component';
import { RepaymentEntityListComponent } from './repaymentEntity/repayment-entity-list.component';
import { CreditEntityListComponent } from './creditEntity/credit-entity-list.component';
import { CreditEntityFormComponent } from './creditEntity/credit-entity-form.component';
import { DepositeListComponent } from './deposite/deposite-list.component';
import { DepositeFormComponent } from './deposite/deposite-form.component';
import { SpendingFormComponent } from './spending/spending-form.component';
import { SpendingListComponent } from './spending/spending-list.component';
import { PurposeFormComponent } from './purpose/purpose-form.component';
import { PurposeListComponent } from './purpose/purpose-list.component';
import { CreditStatusFormComponent } from './creditStatus/credit-status-form.component';
import { CreditStatusListComponent } from './creditStatus/credit-status-list.component';
import { AccountFormComponent } from './Account/account-form.component';
import { AccountListComponent } from './Account/account-list.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CardModule, CarouselModule, GridModule, ToastModule } from '@coreui/angular';
import { IconModule } from '@coreui/icons-angular';
import { AdministrationComponent } from './administration.component';
import { AdministrationRoutingModule } from './administration-routing.module';
import { CarouselAllModule, CarouselAnimationEffect, CarouselComponent, CarouselModule as CarouselModuleSync } from '@syncfusion/ej2-angular-navigations';
import { DropDownListAllModule } from '@syncfusion/ej2-angular-dropdowns';
import { ButtonAllModule, SwitchAllModule } from '@syncfusion/ej2-angular-buttons';
import { NumericTextBoxModule } from '@syncfusion/ej2-angular-inputs';

import { ChartjsModule } from '@coreui/angular-chartjs';

// import { ChartsComponent } from './charts.component';
// import { ChartsRoutingModule } from './charts-routing.module';
// import { DocsComponentsModule } from '@docs-components/docs-components.module';


import {
  ColumnChooserService,
  EditService,
  ExcelExportService,
  FreezeService,
  GridModule as syncGridModule,
  PageService,
  PagerModule,
  PdfExportService,
  ReorderService,
  SortService,
  ToolbarService,
  ResizeService as GridResizeService,
  GroupService,
} from '@syncfusion/ej2-angular-grids';

import { ILoadedEventArgs, ChartTheme, IAccPointRenderEventArgs, IAccLoadedEventArgs, AccumulationTheme, ChartAllModule, AccumulationChartAllModule, ChartModule } from '@syncfusion/ej2-angular-charts';
import { DashboardLayoutModule } from '@syncfusion/ej2-angular-layouts';
import {
  AvatarModule,
  BadgeModule,
  BreadcrumbModule,
  ButtonGroupModule,
  ButtonModule,
  DropdownModule,
  FooterModule,
  FormModule,
  HeaderModule,
  ListGroupModule,
  NavModule,
  ProgressModule,
  SharedModule,
  SidebarModule,
  TabsModule,
  UtilitiesModule,
  

} from '@coreui/angular';
import { DatePickerModule } from '@syncfusion/ej2-angular-calendars';
import { DocsComponentsModule } from '@docs-components/docs-components.module';
@NgModule({
  imports: [
    CardModule,
    GridModule,
    IconModule,
    CommonModule,
    AdministrationRoutingModule,
    syncGridModule,
    FormsModule, AvatarModule,
    BadgeModule,
    BreadcrumbModule,
    ButtonGroupModule,
    ButtonModule,
    DropdownModule,
    FooterModule,
    FormModule,
    HeaderModule,
    ListGroupModule,
    NavModule,
    ProgressModule,
    SharedModule,
    SidebarModule,
    TabsModule,
    UtilitiesModule,
    ToastModule,
    CarouselModule,
    CarouselModuleSync,
    CarouselAllModule,
    DropDownListAllModule,
    ButtonAllModule, SwitchAllModule,
    NumericTextBoxModule,
    ChartAllModule,
    AccumulationChartAllModule,
    DashboardLayoutModule,
    DatePickerModule,
    ChartModule,
    ChartjsModule,
    DocsComponentsModule,
  ],
  declarations: [RepaymentEntityFormComponent, RepaymentEntityListComponent, CreditEntityListComponent, CreditEntityFormComponent, DepositeListComponent, DepositeFormComponent, SpendingListComponent, SpendingFormComponent, PurposeListComponent, PurposeFormComponent, CreditStatusListComponent, CreditStatusFormComponent, AccountListComponent, AccountFormComponent],
  exports: [RepaymentEntityFormComponent, RepaymentEntityListComponent, CreditEntityListComponent, CreditEntityFormComponent, DepositeListComponent, DepositeFormComponent, SpendingListComponent, SpendingFormComponent, CreditStatusListComponent, CreditStatusFormComponent, AccountListComponent, AccountFormComponent],
  providers: [SortService,
    ColumnChooserService,
    EditService,
    ExcelExportService,
    FreezeService,
    PageService,
    PagerModule,
    PdfExportService,
    ReorderService,
    ToolbarService,
    GridResizeService,
    GroupService,
    
  ]
})
export class AdministrationModule {
}
