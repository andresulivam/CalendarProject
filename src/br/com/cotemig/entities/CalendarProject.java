/**
 * 
 */
package br.com.cotemig.entities;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author andresulivam
 *
 */
public class CalendarProject {

	private ArrayList<Event> events;

	/**
	 * @author andresulivam
	 */
	public CalendarProject() {
		events = new ArrayList<Event>();
	}

	/**
	 * @author andresulivam
	 * @return events
	 */
	public ArrayList<Event> getEvents() {
		return events;
	}

	public Event getEventById(Integer id) {
		Event event = null;
		if (id != null) {
			for (int i = 0; i < events.size(); i++) {
				if (events.get(i).getId() == id) {
					event = events.get(i);
					break;
				}
			}
		}
		return event;
	}

	/**
	 * Add new event to calendar
	 * 
	 * @param initial_date
	 * @param final_date
	 * @param name
	 */
	public boolean addEvent(Calendar initial_date, Calendar final_date, String name) {
		boolean result = false;
		Event event = new Event();
		event.setName(name);
		event.setInitial_date(initial_date);
		event.setFinal_date(final_date);

		/* if event was created */
		if (event.getFinal_date() != null && event.getInitial_date() != null) {
			events.add(event);
			result = true;
		}
		return result;
	}

	/**
	 * Add new event to calendar
	 * 
	 * @param initial_date
	 * @param final_date
	 * @param name
	 */
	public boolean addEvent(Event event) {
		boolean result = false;
		/* if event was created */
		if (event != null && event.getFinal_date() != null && event.getInitial_date() != null) {
			events.add(event);
			result = true;
		}
		return result;
	}

	/**
	 * Find events by interval
	 * 
	 * @author andresulivam
	 * @return events
	 */
	public ArrayList<Event> getEventsByInterval(Calendar initial_date, Calendar final_date) {
		ArrayList<Event> result = new ArrayList<Event>();
		boolean insert = true;
		
		for (int i = 0; i < events.size(); i++) {			
			if (initial_date != null && final_date != null) {		
				if (!events.get(i).getInitial_date().after(initial_date)
						|| !events.get(i).getFinal_date().before(final_date)) {
					insert = false;
				}
			} else if (initial_date != null) {
				if (!events.get(i).getInitial_date().after(initial_date)) {
					insert = false;
				}
			} else if (final_date != null) {
				if (!events.get(i).getFinal_date().before(final_date)) {
					insert = false;
				}
			}
			if (insert) {
				result.add(events.get(i));
			}
			insert = true;
		}
		return result;
	}

	/**
	 * Find events from today
	 * 
	 * @author andresulivam
	 * @return events
	 */
	public ArrayList<Event> getEventsByToday() {
		ArrayList<Event> result = new ArrayList<Event>();
		Calendar today = Calendar.getInstance();
		for (int i = 0; i < events.size(); i++) {
			if (events.get(i).getInitial_date().get(Calendar.YEAR) == today.get(Calendar.YEAR)
					&& events.get(i).getInitial_date().get(Calendar.MONTH) == today.get(Calendar.MONTH)
					&& events.get(i).getInitial_date().get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)) {
				result.add(events.get(i));
			}
		}
		return result;
	}

	/**
	 * Find events by past days
	 * 
	 * @author andresulivam
	 * @return events
	 */
	public ArrayList<Event> getEventsByPastDays(int days, Calendar today) {
		ArrayList<Event> result = new ArrayList<Event>();
		today.add(Calendar.DATE, days * (-1));
		for (int i = 0; i < events.size(); i++) {
			if (events.get(i).getInitial_date().get(Calendar.YEAR) == today.get(Calendar.YEAR)
					&& events.get(i).getInitial_date().get(Calendar.MONTH) == today.get(Calendar.MONTH)
					&& events.get(i).getInitial_date().get(Calendar.DAY_OF_MONTH) == today
							.get(Calendar.DAY_OF_MONTH)) {
				result.add(events.get(i));
			}
		}
		return result;
	}

	/**
	 * Find events tomorrow
	 * 
	 * @author andresulivam
	 * @return events
	 */
	public ArrayList<Event> getEventsTomorrow() {
		ArrayList<Event> result = new ArrayList<Event>();
		Calendar day_to_find = Calendar.getInstance();
		day_to_find.add(Calendar.DATE, 1);
		for (int i = 0; i < events.size(); i++) {
			if (events.get(i).getInitial_date().get(Calendar.YEAR) == day_to_find.get(Calendar.YEAR)
					&& events.get(i).getInitial_date().get(Calendar.MONTH) == day_to_find.get(Calendar.MONTH)
					&& events.get(i).getInitial_date().get(Calendar.DAY_OF_MONTH) == day_to_find
							.get(Calendar.DAY_OF_MONTH)) {
				result.add(events.get(i));
			}
		}
		return result;
	}

	/**
	 * Update event
	 * 
	 * @author andresulivam
	 * @param id
	 * @param initial_date
	 * @param final_date
	 * @param name
	 * @return
	 */
	public boolean updateEvent(Integer id, Calendar initial_date, Calendar final_date, String name) {
		boolean result = false;
		Event event = getEventById(id);
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, -1);
		if (event != null && event.getInitial_date().after(today) && event.getFinal_date().after(today)) {
			
			event.setFinal_date(final_date);
			event.setInitial_date(initial_date);
			event.setName(name);
			if (event.getFinal_date().getTimeInMillis() == final_date.getTimeInMillis()
					&& event.getInitial_date().getTimeInMillis() == initial_date.getTimeInMillis()
					&& event.getName() == name) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * Remove event from calendar
	 * 
	 * @author andresulivam
	 * @param id
	 * @return
	 */
	public boolean removeEventById(Integer id) {
		boolean result = false;
		if (id != null) {
			Event event = getEventById(id);
			if (event != null) {
				events.remove(event);
				result = true;
			}
		}
		return result;
	}

}
