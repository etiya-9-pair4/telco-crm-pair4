import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.scss'],
})
export class CreateCustomerComponent implements OnInit {
  mainForm: FormGroup;
  currentTab = 0;

  constructor(private fb: FormBuilder) {
    this.mainForm = this.fb.group({
      customerInfo: this.fb.group({
        firstName: ['', Validators.required],
        natId: ['', [Validators.required, Validators.minLength(11)]],
        middleName: [''],
        birthDate: ['', Validators.required],
        lastName: ['', Validators.required],
        motherName: [''],
        gender: ['', Validators.required],
        fatherName: [''],
      }),
      address: this.fb.group({
        city: ['', Validators.required],
        district: ['', Validators.required],
        houseNumber: ['', Validators.required],
        street: ['', Validators.required],
        addressDescription: [''],
        isDefault: [false],
      }),
      contactMedium: this.fb.group({
        email: ['', [Validators.required, Validators.email]],
        gsmNumber: ['', Validators.required],
        homePhone: [''],
        fax: [''],
      }),
    });
  }

  ngOnInit(): void {}

  showTab(tabIndex: number) {
    // Sekme değiştiğinde yalnızca geçilen sekmenin alanlarını "touched" yapıyoruz
    this.currentTab = tabIndex;
    this.currentFormGroup.markAllAsTouched();
  }

  get currentFormGroup() {
    const groups = ['customerInfo', 'address', 'contactMedium'];
    return this.mainForm.get(groups[this.currentTab]) as FormGroup;
  }

  nextTab() {
    // Mevcut sekmedeki tüm alanları "touched" yaparak validasyon hatalarını gösteriyoruz
    this.currentFormGroup.markAllAsTouched();

    // Eğer mevcut sekmedeki form geçerliyse bir sonraki sekmeye geçiyoruz
    if (this.currentFormGroup.valid) {
      this.currentTab++;
    }
  }

  prevTab() {
    if (this.currentTab > 0) {
      this.currentTab--;
    }
  }

  onSubmit() {
    // Tüm formu "touched" yaparak hataları göster
    this.mainForm.markAllAsTouched();

    if (this.mainForm.valid) {
      console.log('Form submitted:', this.mainForm.value);
      // Form geçerli olduğunda burada gerekli işlemleri yapabilirsiniz
    } else {
      console.log('Form has errors');
    }
  }
}
