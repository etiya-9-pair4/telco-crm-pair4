import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { IndividualCustomerService } from '../../services/individualcustomer.service';
import {
  digitLengthValidator,
  exactDigitLengthValidator,
  nameValidator,
  gsmNumberValidator,
  maxDigitLengthValidator,
} from '../../../../core/validators/custom-validators';
import { SearchIndividualCustomerResponseDto } from '../../models/response';
import { SearchIndividualCustomerRequestDto } from '../../models/request';

@Component({
  selector: 'app-search-customer',
  templateUrl: './search-customer.component.html',
  styleUrls: ['./search-customer.component.scss'],
})
export class SearchCustomerComponent implements OnInit {
  searchForm!: FormGroup;
  customers: SearchIndividualCustomerResponseDto[] = [];
  searched: boolean = false;

  constructor(
    private fb: FormBuilder,
    private individualCustomerService: IndividualCustomerService
  ) {}

  ngOnInit(): void {
    this.searchForm = this.fb.group({
      customerId: ['', [Validators.min(1), maxDigitLengthValidator(10)]],
      nationalityId: ['', [exactDigitLengthValidator(11)]],
      accountNumber: ['', [exactDigitLengthValidator(10)]],
      firstName: ['', nameValidator(2, 20)],
      middleName: ['', nameValidator(2, 20)],
      lastName: ['', nameValidator(2, 20)],
      mobilePhone: ['', [exactDigitLengthValidator(10), gsmNumberValidator()]],
    });
  }

  search(): void {
    // Formdaki alanlardan doldurulanları alarak DTO'ya aktar
    const searchDto: SearchIndividualCustomerRequestDto = {
      customerId: this.searchForm.get('customerId')?.value || null,
      nationalityId: this.searchForm.get('nationalityId')?.value || null,
      accountNumber: this.searchForm.get('accountNumber')?.value || null,
      firstName: this.searchForm.get('firstName')?.value || null,
      middleName: this.searchForm.get('middleName')?.value || null,
      lastName: this.searchForm.get('lastName')?.value || null,
      mobilePhone: this.searchForm.get('mobilePhone')?.value || null,
    };

    this.individualCustomerService.searchCustomers(searchDto).subscribe({
      next: (response) => {
        this.customers = response;
        console.log('Search results:', this.customers);
      },
      error: (err) => {
        console.error('Error during search:', err);
        this.customers = [];
        this.searched = true;
      },
    });
  }

  clearAll(): void {
    this.searchForm.reset();
    this.customers = [];
    this.searched = false;
  }

  isFormEmpty(): boolean {
    return Object.values(this.searchForm.value).every((value) => value === '');
  }

  onInputRestriction(
    event: Event,
    maxLength: number,
    isAlphabetOnly: boolean = false
  ): void {
    const input = event.target as HTMLInputElement;
    if (isAlphabetOnly) {
      input.value = input.value.replace(/[^a-zA-Z\s]/g, '').slice(0, maxLength); // Yalnızca harf ve boşluk
    } else {
      input.value = input.value.replace(/[^0-9]/g, '').slice(0, maxLength); // Yalnızca rakam
    }
    const controlName = input.getAttribute('formControlName');
    if (controlName) {
      this.searchForm.get(controlName)?.setValue(input.value);
    }
  }
}
