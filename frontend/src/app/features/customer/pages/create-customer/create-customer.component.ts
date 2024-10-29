import { Component, AfterViewInit } from '@angular/core';
import {
  InstanceOptions,
  TabItem,
  Tabs,
  TabsInterface,
  TabsOptions,
} from 'flowbite';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.scss'], // styleUrls 'a dikkat edin, 'styleUrl' yanlış yazılmış
})
export class CreateCustomerComponent implements AfterViewInit {
  tabsElement!: HTMLElement; // Başlangıçta undefined
  tabElements: TabItem[] = [];
  options: TabsOptions = {
    defaultTabId: 'profile',
    activeClasses: 'underline underline-offset-4',
    inactiveClasses: 'text-white',
    onShow: () => {
      console.log('tab is shown');
    },
  };
  instanceOptions: InstanceOptions = {
    id: 'tabs-example',
    override: true,
  };
  tabs!: TabsInterface; // Başlangıçta undefined

  ngAfterViewInit() {
    // DOM yüklendikten sonra elementleri al
    this.tabsElement = document.getElementById('tabs-example') as HTMLElement;
    this.tabElements = [
      {
        id: 'profile',
        triggerEl: document.querySelector(
          '#profile-tab-example'
        ) as HTMLElement,
        targetEl: document.querySelector('#profile-example') as HTMLElement,
      },
      {
        id: 'dashboard',
        triggerEl: document.querySelector(
          '#dashboard-tab-example'
        ) as HTMLElement,
        targetEl: document.querySelector('#dashboard-example') as HTMLElement,
      },
      {
        id: 'settings',
        triggerEl: document.querySelector(
          '#settings-tab-example'
        ) as HTMLElement,
        targetEl: document.querySelector('#settings-example') as HTMLElement,
      },
    ];

    // Tabs örneğini oluştur
    this.tabs = new Tabs(
      this.tabsElement,
      this.tabElements,
      this.options,
      this.instanceOptions
    );
  }
}
