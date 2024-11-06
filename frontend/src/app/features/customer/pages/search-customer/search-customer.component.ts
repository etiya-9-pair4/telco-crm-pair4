import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { IndividualCustomerService } from '../../services/individualcustomer.service';
import {
  digitLengthValidator,
  exactDigitLengthValidator,
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

  constructor(
    private fb: FormBuilder,
    private individualCustomerService: IndividualCustomerService
  ) {}

  ngOnInit(): void {
    this.searchForm = this.fb.group({
      customerId: ['', [Validators.min(1), digitLengthValidator(10)]],
      nationalityId: ['', [exactDigitLengthValidator(11)]],
      accountNumber: ['', [exactDigitLengthValidator(10)]],
      firstName: [
        '',
        [
          Validators.minLength(2),
          Validators.maxLength(20),
          Validators.pattern(/^[A-Za-z]+$/),
        ],
      ],
      middleName: [
        '',
        [
          Validators.minLength(2),
          Validators.maxLength(20),
          Validators.pattern(/^[A-Za-z]+$/),
        ],
      ],
      lastName: [
        '',
        [
          Validators.minLength(2),
          Validators.maxLength(20),
          Validators.pattern(/^[A-Za-z]+$/),
        ],
      ],
      mobilePhone: [
        '',
        [exactDigitLengthValidator(10), Validators.pattern(/^[0-9]+$/)],
      ],
    });
  }

  search(): void {
    const searchDto: SearchIndividualCustomerRequestDto = this.searchForm.value;
    this.individualCustomerService.searchCustomers(searchDto).subscribe({
      next: (response) => {
        this.customers = response;
        console.log('Search results:', this.customers);
      },
      error: (err) => console.error(err),
    });
  }
  getFilledFormValues(): Record<string, any> {
    const formValues = this.searchForm.value;
    return Object.keys(formValues)
      .filter((key) => formValues[key] !== '' && formValues[key] !== null)
      .reduce((acc: Record<string, any>, key: string) => {
        acc[key] = formValues[key];
        return acc;
      }, {} as Record<string, any>);
  }
  clearAll(): void {
    this.searchForm.reset();
  }

  isFormEmpty(): boolean {
    return Object.values(this.searchForm.value).every((value) => value === '');
  }

  onInputRestriction(event: Event, maxLength: number): void {
    const input = event.target as HTMLInputElement;
    input.value = input.value.replace(/[^0-9]/g, '').slice(0, maxLength);
    const controlName = input.getAttribute('formControlName');
    if (controlName) {
      this.searchForm.get(controlName)?.setValue(input.value);
    }
  }

  onNatIdInput(event: Event): void {
    const input = event.target as HTMLInputElement;
    input.value = input.value.replace(/[^0-9]/g, '');
    this.searchForm.get('natId')?.setValue(input.value);
  }

  onGsmNumberInput(event: Event): void {
    const input = event.target as HTMLInputElement;
    input.value = input.value.replace(/[^0-9]/g, '');
    this.searchForm.get('gsmNumber')?.setValue(input.value);
  }
}
