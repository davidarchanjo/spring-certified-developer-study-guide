package io.davidarchanjo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeHealthInsurance {

    private String empId;
	private String healthInsuranceSchemeName;
	private int coverageAmount;

    @Builder
    public EmployeeHealthInsurance(String empId, String healthInsuranceSchemeName, int coverageAmount) {
        this.empId = empId;
        this.healthInsuranceSchemeName = healthInsuranceSchemeName;
        this.coverageAmount = coverageAmount;
    }
}