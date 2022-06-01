package com.example.web;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class CourseForm implements Serializable {

    // serialVersionUIDを指定
    private static final long serialVersionUID = 1L;

    @NotEmpty
	private String courseNo;
    @NotEmpty
    private String courseName;

    private String year;
    private String month;
    private String day;

    private List<String> eventDate;

    private String startHour;
    private String startMinutes;
    private String finishHour;
    private String finishMinutes;

    @NotNull
    @Range(min=1, max=50, message="{0}は、{min}以上{max}以下で入力してください。")
    private Integer capcity;

    /**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd セットする passwd
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	private String userId;
    private String passwd;

	/**
	 * @return courseNum
	 */
	public String getCourseNo() {
		return courseNo;
	}
	/**
	 * @param courseNum セットする courseNum
	 */
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	/**
	 * @return courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName セットする courseName
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year セットする year
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month セットする month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return day
	 */
	public String getDay() {
		return day;
	}
	/**
	 * @param day セットする day
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * @return eventDate
	 */
	public List<String> getEventDate() {
		return eventDate;
	}
	/**
	 * @param eventDate セットする eventDate
	 */
	public void setEventDate(List<String> eventDate) {
		this.eventDate = eventDate;
	}
	/**
	 * @return startHour
	 */
	public String getStartHour() {
		return startHour;
	}
	/**
	 * @param startHour セットする startHour
	 */
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}
	/**
	 * @return startMinutes
	 */
	public String getStartMinutes() {
		return startMinutes;
	}
	/**
	 * @param startMinutes セットする startMinutes
	 */
	public void setStartMinutes(String startMinutes) {
		this.startMinutes = startMinutes;
	}
	/**
	 * @return finishHour
	 */
	public String getFinishHour() {
		return finishHour;
	}
	/**
	 * @param finishHour セットする finishHour
	 */
	public void setFinishHour(String finishHour) {
		this.finishHour = finishHour;
	}
	/**
	 * @return finishMinutes
	 */
	public String getFinishMinutes() {
		return finishMinutes;
	}
	/**
	 * @param finishMinutes セットする finishMinutes
	 */
	public void setFinishMinutes(String finishMinutes) {
		this.finishMinutes = finishMinutes;
	}
	/**
	 * @return capacity
	 */
	public Integer getCapcity() {
		return capcity;
	}
	/**
	 * @param capacity セットする capacity
	 */
	public void setCapcity(Integer capacity) {
		this.capcity = capacity;
	}

	public List<String> getEvent(){
		List<String> eventYear = new ArrayList<String>();

		LocalDateTime ldt = LocalDateTime.now();
		int year = ldt.getYear();
		String yearList = "";

		for(int i = 0; i <= 5;i++) {
			yearList = String.valueOf(year);
			eventYear.add(yearList);

			year += 1;
		}

		return eventYear;

	}

}