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
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'RepaymentEntityList',
    component: RepaymentEntityListComponent,
    data: {
      title: 'RepaymentEntity'
    }
  },
  {
    path: 'RepaymentEntityForm',
    component: RepaymentEntityFormComponent,
    data: {
      title: 'RepaymentEntity'
    }
  },

  {
    path: 'CreditEntityList',
    component: CreditEntityListComponent,
    data: {
      title: 'CreditEntity'
    }
  },
  {
    path: 'CreditEntityForm',
    component: CreditEntityFormComponent,
    data: {
      title: 'CreditEntity'
    }
  },
  
  {
    path: 'DepositeList',
    component: DepositeListComponent,
    data: {
      title: 'Deposite'
    }
  },
  {
    path: 'DepositeForm',
    component: DepositeFormComponent,
    data: {
      title: 'Deposite'
    }
  },

  {
    path: 'SpendingList',
    component: SpendingListComponent,
    data: {
      title: 'Spending'
    }
  },
  {
    path: 'SpendingForm',
    component: SpendingFormComponent,
    data: {
      title: 'Spending'
    }
  },

  {
    path: 'PurposeList',
    component: PurposeListComponent,
    data: {
      title: 'Purpose'
    }
  },
  {
    path: 'PurposeForm',
    component: PurposeFormComponent,
    data: {
      title: 'Purpose'
    }
  },

  {
    path: 'CreditStatusList',
    component: CreditStatusListComponent,
    data: {
      title: 'CreditStatus'
    }
  },
  {
    path: 'CreditStatusForm',
    component: CreditStatusFormComponent,
    data: {
      title: 'CreditStatus'
    }
  },

  {
    path: 'AccountList',
    component: AccountListComponent,
    data: {
      title: 'Account'
    }
  },
  {
    path: 'AccountForm',
    component: AccountFormComponent,
    data: {
      title: 'Account'
    }
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministrationRoutingModule {
}
