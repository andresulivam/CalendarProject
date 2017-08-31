/**
 * 
 */
package br.com.cotemig.entities;

import java.util.Calendar;

/**
 * @author andresulivam
 *
 */
public class Event {

	private Integer count = 1;

	private Integer id;
	private Calendar initial_date;
	private Calendar final_date;
	private String name;
	private CalendarProject calendar;

	public Event() {
		this.id = count;
		count++;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the initial_date
	 */
	public Calendar getInitial_date() {
		return initial_date;
	}

	/**
	 * @param initial_date
	 *            the initial_date to set
	 */
	public void setInitial_date(Calendar initial_date) {
		if (initial_date != null) {
			Calendar today = Calendar.getInstance();
			if (today.getTimeInMillis() <= initial_date.getTimeInMillis()) {
				if (this.final_date != null) {
					/* Validate dates */					
					if (this.final_date.getTimeInMillis() >= initial_date.getTimeInMillis()) {
						this.initial_date = initial_date;
					}
				} else {
					this.initial_date = initial_date;
				}
			}
		}
	}

	/**
	 * @return the final_date
	 */
	public Calendar getFinal_date() {
		return final_date;
	}

	/**
	 * @param final_date
	 *            the final_date to set
	 */
	public void setFinal_date(Calendar final_date) {
		if (final_date != null) {
			Calendar today = Calendar.getInstance();
			if (today.getTimeInMillis() <= final_date.getTimeInMillis()) {
				if (this.initial_date != null) {
					/* Validate dates */
					if (this.initial_date.getTimeInMillis() <= final_date.getTimeInMillis()) {
						this.final_date = final_date;
					}
				} else {
					this.final_date = final_date;
				}
			}
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		if(name != null){
			this.name = name;
		}
	}

	/**
	 * @return the calendar
	 */
	public CalendarProject getCalendarProject() {
		return calendar;
	}

	/**
	 * @param calendar
	 *            the calendar to set
	 */
	public void setCalendar(CalendarProject calendar) {
		this.calendar = calendar;
	}

}
