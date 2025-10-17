# HospitalDB REST API

A simple Spring Boot REST API for managing a hospital database including patients, doctors, departments, insurance, and appointments.

---

## Table of Contents

- [Basic CRUD Endpoints](#basic-crud-endpoints)
    - [Patient](#1-patient)
    - [Doctor](#2-doctor)
    - [Department](#3-department)
    - [Insurance](#4-insurance)
    - [Appointment](#5-appointment)
    - [DoctorDepartment](#6-doctordepartment)
- [Advanced Endpoints](#advanced-endpoints)
    - [Patient Analytics & Reporting](#1-patient-analytics--reporting)
    - [Doctor & Department Analytics](#2-doctor--department-analytics)
    - [Appointment Advanced Endpoints](#3-appointment-advanced-endpoints)
    - [Insurance Insights](#4-insurance-insights)
    - [Combined Reports](#5-combined-reports)
    - [Misc / Utility](#6-misc--utility)

---

## Basic CRUD Endpoints

### 1. Patient

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/patients` | Get all patients |
| GET | `/api/patients/{id}` | Get patient by ID |
| POST | `/api/patients` | Create a new patient |
| PUT | `/api/patients/{id}` | Update an existing patient |
| DELETE | `/api/patients/{id}` | Delete a patient |
| GET | `/api/patients/search?name={name}` | Search patients by name |

### 2. Doctor

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/doctors` | Get all doctors |
| GET | `/api/doctors/{id}` | Get doctor by ID |
| POST | `/api/doctors` | Create a new doctor |
| PUT | `/api/doctors/{id}` | Update an existing doctor |
| DELETE | `/api/doctors/{id}` | Delete a doctor |
| GET | `/api/doctors/search?name={name}` | Search doctors by name |
| GET | `/api/doctors/{id}/departments` | Get all departments of a doctor |

### 3. Department

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/departments` | Get all departments |
| GET | `/api/departments/{id}` | Get department by ID |
| POST | `/api/departments` | Create a new department |
| PUT | `/api/departments/{id}` | Update a department |
| DELETE | `/api/departments/{id}` | Delete a department |
| GET | `/api/departments/{id}/doctors` | Get all doctors in a department |

### 4. Insurance

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/insurances` | Get all insurance records |
| GET | `/api/insurances/{id}` | Get insurance by ID |
| POST | `/api/insurances` | Create a new insurance |
| PUT | `/api/insurances/{id}` | Update insurance |
| DELETE | `/api/insurances/{id}` | Delete insurance |

### 5. Appointment

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/appointments` | Get all appointments |
| GET | `/api/appointments/{id}` | Get appointment by ID |
| POST | `/api/appointments` | Create a new appointment |
| PUT | `/api/appointments/{id}` | Update an appointment |
| DELETE | `/api/appointments/{id}` | Delete an appointment |
| GET | `/api/appointments/patient/{patientId}` | Get all appointments of a patient |
| GET | `/api/appointments/doctor/{doctorId}` | Get all appointments of a doctor |
| GET | `/api/appointments/status/{status}` | Filter appointments by status |
| GET | `/api/appointments/date?from=YYYY-MM-DD&to=YYYY-MM-DD` | Filter appointments by date range |

### 6. DoctorDepartment (Association Table)

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/doctor-department` | Assign doctor to department |
| DELETE | `/api/doctor-department` | Remove doctor from department |

---

## Advanced Endpoints

### 1. Patient Analytics & Reporting

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/patients/count-by-gender` | GET | Returns patient count grouped by gender |
| `/api/patients/recent?days=N` | GET | Returns patients added in the last N days |
| `/api/patients/with-no-appointments` | GET | Lists patients who have never had an appointment |
| `/api/patients/with-insurance` | GET | Lists patients with insurance coverage |
| `/api/patients/search?name=&gender=&ageFrom=&ageTo=&address=` | GET | Advanced patient search |

### 2. Doctor & Department Analytics

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/doctors/appointment-count` | GET | Returns doctors with number of appointments |
| `/api/doctors/busy?minAppointments=N` | GET | Returns doctors with more than N appointments in a period |
| `/api/departments/doctor-count` | GET | Returns number of doctors per department |
| `/api/departments/appointment-count` | GET | Returns number of appointments per department |

### 3. Appointment Advanced Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/appointments/upcoming?days=N` | GET | Returns upcoming appointments in the next N days |
| `/api/appointments/patient-history/{patientId}` | GET | Returns all appointments of a patient with doctor and department info |
| `/api/appointments/doctor-schedule/{doctorId}?date=YYYY-MM-DD` | GET | Returns doctor schedule for a specific date |
| `/api/appointments/status-count` | GET | Returns count of appointments by status |
| `/api/appointments/search?patient=&doctor=&status=&department=&from=&to=` | GET | Filter appointments by multiple criteria |

### 4. Insurance Insights

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/insurances/coverage-summary` | GET | Returns number of patients per insurance provider |
| `/api/insurances/patients?provider=` | GET | Lists patients under a specific insurance provider |

### 5. Combined Reports

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/reports/daily-summary` | GET | Daily report: new patients, appointments, doctors |
| `/api/reports/doctor-workload` | GET | Shows doctor workload per day/week |
| `/api/reports/patient-activity` | GET | Shows patient visit frequency, no-shows, cancellations |

### 6. Misc / Utility

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/notifications/upcoming-appointments` | GET | Returns upcoming appointments for sending reminders |
| `/api/notifications/missed-appointments` | GET | Returns patients who missed appointments |
| `/api/statistics/age-distribution` | GET | Returns patient age distribution (0-18, 19-35, etc.) |

---

## Notes

1. All endpoints return DTO objects (e.g., `PatientDto`, `DoctorDto`).
2. Pagination is recommended for list endpoints (`?page=0&size=20`).
3. Filtering/search endpoints can be extended with query parameters.
4. All endpoints are prefixed with `/api`.
5. Advanced endpoints are designed for dashboards, analytics, and reporting.

---

