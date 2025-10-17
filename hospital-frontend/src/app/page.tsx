import * as React from "react"
import { getPatients } from "@/lib/api";
import { PatientDto } from "@/types";
import { Card } from "@/components/ui/card";

export default async function PatientsPage() {
    const patients: PatientDto[] = await getPatients();

    return (
        <div className="p-6 grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
            {patients.map((patient) => (
                <Card key={patient.patientId}>
                    <h2 className="text-lg font-bold">
                        {patient.firstName} {patient.lastName}
                    </h2>
                    <p>Gender: {patient.gender}</p>
                    <p>Address: {patient.address}</p>
                    <p>DOB: {patient.dateOfBirth}</p>
                </Card>
            ))}
        </div>
    );
}
