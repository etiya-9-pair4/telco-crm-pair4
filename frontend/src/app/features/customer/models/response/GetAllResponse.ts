export interface GetAllResponse {
  customerId: number;
  nationalityId: number;
  firstName: string;
  middleName?: string;
  lastName: string;
  dateOfBirth: string;
  motherName: string;
  fatherName: string;
  genderId: number;
  customerAccounts: any;
  contacts: any;
}
