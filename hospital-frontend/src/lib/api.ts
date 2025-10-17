import { PatientDto } from "@/types";

const API_BASE = process.env.NEXT_PUBLIC_API_BASE || "http://localhost:8080/api/patients";

export async function getPatients(): Promise<PatientDto[]> {
    const res = await fetch(`${API_BASE}/all`);
    if (!res.ok) throw new Error("Failed to fetch patients");
    return res.json();
}
