export interface SearchIndividualCustomerResponseDto {
  customerId: number;
  nationalityId: number;
  accountNumber: string;
  firstName: string;
  middleName: string;
  lastName: string;
  mobilePhone: string;
  contacts?: { gsmNumber: string }[]; // contacts alanını ekleyin
}
