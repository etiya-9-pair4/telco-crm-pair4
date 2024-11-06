export interface SearchIndividualCustomerRequestDto {
  customerId?: number;
  nationalityId?: number;
  accountNumber?: string;
  firstName?: string;
  middleName?: string;
  lastName?: string;
  mobilePhone?: string;
  customerAccount?: number;
  contacts?: number;
}
