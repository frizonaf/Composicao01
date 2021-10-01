package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
		// associações
	private Department department;
	
	private List<HourContract> contracts = new ArrayList<>();	// lista precisa ser instanciada não instanciar no construtor
				// sempre que um trabalhador for criado, precisará de uma lista vazia de contratos
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	public Double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		
		for (HourContract cont: contracts) {
			cal.setTime(cont.getDate());	// set a data cal com a data do contrato
			int c_month = cal.get(Calendar.YEAR);
			int c_year = 1 + cal.get(Calendar.MONTH);	// o mês do Calendar inicia com 0 (acrescentar 1)
			if (c_month == month && c_year == year) {
				sum += cont.totalValue();
			}
		}
		return sum;
	}
}
