package com.example.domain;

public class ProductInfo {

	//データベース用変数
	private String courseNo;
	private String courseName;
    private String theDate;
    private String startTime;
    private String endTime;
    private Integer capcity;

    //日時合体用変数
    private String year;
    private String month;
    private String day;

    //開始・終了時刻用変数
    private String startHour;
    private String startMinutes;
    private String finishHour;
    private String finishMinutes;

    /**
	 * @return courseNo
	 */
	public String getCourseNo() {
		return courseNo;
	}
	/**
	 * @param courseNo セットする courseNo
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
	 * @return theDate
	 */
	public String getTheDate() {


		return theDate;
	}
	/**
	 * @param theDate セットする theDate
	 */
	public void setTheDate(String theDate) {
		this.theDate = theDate;
	}
	/**
	 * @return startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime セットする startTime
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime セットする endTime
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return capcity
	 */
	public Integer getCapcity() {
		return capcity;
	}
	/**
	 * @param capcity セットする capcity
	 */
	public void setCapcity(Integer capcity) {
		this.capcity = capcity;
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

}