import { Component, OnInit } from '@angular/core';
import { Collapse, CollapseInterface } from 'flowbite';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {
  collapseInstances: { [key: string]: CollapseInterface } = {};

  ngOnInit() {
    // Dropdownları başlatıyoruz
    this.initializeCollapse('b2c-toggle', 'b2c-link');
    this.initializeCollapse('b2b-toggle', 'b2b-link');
  }

  initializeCollapse(targetId: string, triggerId: string) {
    const targetEl = document.getElementById(targetId) as HTMLElement;
    const triggerEl = document.getElementById(triggerId) as HTMLElement;

    if (targetEl && triggerEl) {
      this.collapseInstances[targetId] = new Collapse(targetEl, triggerEl);
    }
  }

  toggleDropdown(targetId: string) {
    const collapseInstance = this.collapseInstances[targetId];
    if (collapseInstance) {
      collapseInstance.toggle();
    }
  }
}
