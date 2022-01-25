DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS employeeHealthInsurance;

CREATE TABLE employee (
  empId NUMBER NOT NULL,
  empName VARCHAR(100) NOT NULL
);

CREATE TABLE employeeHealthInsurance (
  empId NUMBER NOT NULL,
  healthInsuranceSchemeName VARCHAR(100) NOT NULL,
  coverageAmount VARCHAR(100) NOT NULL
);