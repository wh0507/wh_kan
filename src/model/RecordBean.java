package model;

import java.util.Date;

public class RecordBean {

	private int id;
	private String userId;
	private Date inputDate;
	private double height, weight, temperature;
	private String text;

	public RecordBean(String userId) {
		this.userId = userId;
	}

	public RecordBean(int id, String userId, Date inputDate, double height, double weight, double temperature,
			String text) {
		this.id = id;
		this.userId = userId;
		this.inputDate = inputDate;
		this.height = height;
		this.weight = weight;
		this.temperature = temperature;
		this.text = text;
	}

	public RecordBean(Date inputDate, double height, double weight, double temperature) {
		this.inputDate = inputDate;
		this.height = height;
		this.weight = weight;
		this.temperature = temperature;
	}

	public RecordBean(int id, Date inputDate, double height, double weight, double temperature) {
		this.id = id;
		this.inputDate = inputDate;
		this.height = height;
		this.weight = weight;
		this.temperature = temperature;
	}

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

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
