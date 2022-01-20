DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS employeeHealthInsurance;

CREATE TABLE employee (
  empId VARCHAR(10) NOT NULL,
  empName VARCHAR(100) NOT NULL
);

CREATE TABLE employeeHealthInsurance (
  empId VARCHAR(10) NOT NULL,
  healthInsuranceSchemeName VARCHAR(100) NOT NULL,
  coverageAmount VARCHAR(100) NOT NULL
);