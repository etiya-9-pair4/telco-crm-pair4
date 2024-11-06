export interface ContactRequest {
  customerId: number;
  email: string;
  mobilePhone: string;
  homePhone?: string;
  faxNumber?: string;
}
