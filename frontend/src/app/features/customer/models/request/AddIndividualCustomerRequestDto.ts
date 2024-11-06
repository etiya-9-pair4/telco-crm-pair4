export interface AddIndividualCustomerRequestDto {
  nationalityId: bigint;
  firstName: string;
  middleName?: string;
  lastName: string;
  dateOfBirth: string; // ISO tarih formatında
  motherName?: string;
  fatherName?: string;
  genderId: number;
}
