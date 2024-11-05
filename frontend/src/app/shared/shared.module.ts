import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedRoutingModule } from './shared-routing.module';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { LoginpageComponent } from './pages/loginpage/loginpage.component';

@NgModule({
  declarations: [
    NavbarComponent,
    FooterComponent,
    MainLayoutComponent,
    HomepageComponent,
    LoginpageComponent,
  ],
  imports: [CommonModule, SharedRoutingModule],
  exports: [
    NavbarComponent,
    FooterComponent,
    MainLayoutComponent,
    HomepageComponent,
    LoginpageComponent,
  ],
})
export class SharedModule {}
