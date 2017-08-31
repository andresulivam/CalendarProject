/**
 * 
 */
package br.com.cotemig.entities;

import java.util.Calendar;

/**
 * @author andresulivam
 *
 */
public class SetterEvent {

	private static int count = 1;
	private static Calendar initial_date = Calendar.getInstance();
	private static Calendar final_date = Calendar.getInstance();

	public static Event settlerEvent() {

		Event event = new Event();
		
		initial_date.add(Calendar.DATE, 1);
		final_date.add(Calendar.DATE, 2);
		
		event.setInitial_date(initial_date);
		event.setFinal_date(final_date);
		event.setName("Event: " + count);

		count++;

		return event;
	}

	public static Event settlerEventWithoutDateValues() {

		Event event = new Event();
		event.setName("Event: " + count);

		count++;
		initial_date.add(Calendar.DATE, 1);
		final_date.add(Calendar.DATE, 2);

		return event;
	}
}
