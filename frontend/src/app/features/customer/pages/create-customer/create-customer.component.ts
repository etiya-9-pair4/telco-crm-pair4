import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {
  AddIndividualCustomerRequestDto,
  AddressRequest,
  ContactRequest,
} from '../../models/request';
import { IndividualCustomerService } from '../../services/individualcustomer.service';
import { AddressService } from '../../services/address.service';
import { ContactService } from '../../services/contact.service';
import { ToastrService } from 'ngx-toastr';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.scss'],
})
export class CreateCustomerComponent implements OnInit {
  mainForm: FormGroup;
  currentTab = 0;
  districts = ['Kadıköy', 'Beşiktaş', 'Çankaya'];
  genders = ['Kadın', 'Erkek', 'Belirtmek İstemiyorum'];
  customerInfoData: AddIndividualCustomerRequestDto | null = null;
  addressData: AddressRequest | null = null;
  contactData: ContactRequest | null = null;
  customerId: number | null = null;

  constructor(
    private fb: FormBuilder,
    private customerService: IndividualCustomerService,
    private addressService: AddressService,
    private contactService: ContactService,
    private toastr: ToastrService
  ) {
    this.mainForm = this.fb.group({
      customerInfo: this.fb.group({
        firstName: ['', Validators.required],
        natId: ['', [Validators.required, Validators.pattern(/^\d{11}$/)]],
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

  get currentFormGroup() {
    const groups = ['customerInfo', 'address', 'contactMedium'];
    return this.mainForm.get(groups[this.currentTab]) as FormGroup;
  }

  nextTab() {
    // İlgili form grubunun geçerli olup olmadığını kontrol et
    if (!this.currentFormGroup.valid) {
      // Form geçerli değilse kullanıcıya bir mesaj gösterebiliriz
      this.toastr.warning('Lütfen gerekli tüm alanları doldurun.');
      return; // Form geçersizse ilerleme
    }

    // İlk sekmedeyken müşteri bilgilerini hazırla
    if (this.currentTab === 0) {
      const birthDateValue = this.mainForm.get('customerInfo.birthDate')?.value;
      const formattedBirthDate = new Date(birthDateValue).toISOString();

      this.customerInfoData = {
        ...this.mainForm.get('customerInfo')?.value,
        dateOfBirth: formattedBirthDate,
        middleName: this.mainForm.get('customerInfo.middleName')?.value || null,
        motherName: this.mainForm.get('customerInfo.motherName')?.value || null,
        fatherName: this.mainForm.get('customerInfo.fatherName')?.value || null,
      };
    }
    // İkinci sekmedeyken adres bilgilerini hazırla
    else if (this.currentTab === 1) {
      this.addressData = {
        description:
          this.mainForm.get('address.addressDescription')?.value || null,
        customerId: 0, // customerId henüz yoksa 0 olarak bırakıyoruz
        districtId: this.mainForm.get('address.district')?.value || null,
        street: this.mainForm.get('address.street')?.value || null,
        houseNumber: this.mainForm.get('address.houseNumber')?.value || null,
        default: this.mainForm.get('address.isDefault')?.value ? 1 : 0,
      };
    }

    // Son olarak sekme indeksini artır
    this.currentTab++;
  }

  prevTab() {
    if (this.currentTab > 0) {
      this.currentTab--;
    }
  }
  onSubmit() {
    this.customerService.add(this.customerInfoData!).subscribe({
      next: (response) => {
        const customerId = response.id; // Oluşturulan müşteri ID'sini aldıktan sonra

        // Diğer verileri eklerken customerId'yi ekleyin
        this.addressData!.customerId = customerId;
        this.contactData!.customerId = customerId;

        this.addressService.add(this.addressData!).subscribe({
          next: () => {
            this.contactService.add(this.contactData!).subscribe({
              next: () => this.toastr.success('Customer created successfully!'),
              error: (error) => this.handleError(error),
            });
          },
          error: (error) => this.handleError(error),
        });
      },
      error: (error) => this.handleError(error),
    });
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error && typeof error.error === 'object') {
      Object.entries(error.error).forEach(([field, message]) => {
        this.toastr.error(`${field}: ${message}`, 'Validation Error');
      });
    } else {
      this.toastr.error('An unexpected error occurred. Please try again.');
    }
    console.error('Error details:', error);
  }
}
