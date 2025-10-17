export interface PatientDto {
    patientId: number;
    firstName: string;
    lastName: string;
    dateOfBirth: string;
    gender: string;
    phoneNumber: string;
    address: string;
    insuranceId: number | null;
}
