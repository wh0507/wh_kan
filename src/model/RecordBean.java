package model;

import java.time.LocalDate;

public class RecordBean {

	private int id;
	private String userId;
	private LocalDate inputDate;
	private double height, weight, temperature;
	private String note;

	public RecordBean() {

	}

	//findAll()
	public RecordBean(int id, String userId, LocalDate inputDate, double height, double weight, double temperature,
			String note) {
		this.id = id;
		this.userId = userId;
		this.inputDate = inputDate;
		this.height = height;
		this.weight = weight;
		this.temperature = temperature;
		this.note = note;
	}

	//
	//	public RecordBean(LocalDate inputDate, double height, double weight, double temperature) {
	//		this.inputDate = inputDate;
	//		this.height = height;
	//		this.weight = weight;
	//		this.temperature = temperature;
	//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDate getInputDate() {
		return inputDate;
	}

	public void setInputDate(LocalDate inputDate) {
		this.inputDate = inputDate;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
