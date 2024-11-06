export interface ContactResponse {
  id: number;
  customerId: number;
  email: string;
  mobilePhone: string;
  homePhone?: string;
  faxNumber?: string;
}
