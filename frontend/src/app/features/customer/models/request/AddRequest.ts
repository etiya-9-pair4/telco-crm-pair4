export interface AddRequest {
  nationalityId: number;
  firstName: string;
  middleName?: string;
  lastName: string;
  dateOfBirth: string;
  motherName: string;
  fatherName: string;
  genderId: number;
}
