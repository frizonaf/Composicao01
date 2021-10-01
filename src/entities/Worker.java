package entities;

import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private Department dep;
	private List<HourContract> contracts;
	
}
