import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedRoutingModule } from './shared-routing.module';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { HomepageComponent } from './pages/homepage/homepage.component';

@NgModule({
  declarations: [
    NavbarComponent,
    FooterComponent,
    MainLayoutComponent,
    HomepageComponent,
  ], // Bu modül altındaki (bu modülün sahip olduğu) schemaricler (NavbarComponent)
  imports: [CommonModule, SharedRoutingModule], //Bu modülün dışarıdan aldığı modül ya da standalone componentlar
  exports: [], //Bu mobil import edildiğinde dışarıdan hangi schematiclerine erişim açılacak?
})
export class SharedModule {}
