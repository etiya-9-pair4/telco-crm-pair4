export interface DeleteResponse {
  customerId: number;
  firstName: string;
  middleName?: string; // Opsiyonel olabilir
  lastName: string;
  createdDate: string; // Tarihler için ISO formatı (string)
  deletedDate: string;
}
