package br.com.cotemig.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalendarProjectTest {

	private static CalendarProject calendar;

	@Before
	public void setUp() throws Exception {
		calendar = SetterCalendar.settlerCalendar();
	}

	@Test
	public void testGetEvents() {
		calendar.addEvent(SetterEvent.settlerEvent());
		calendar.addEvent(SetterEvent.settlerEvent());
		calendar.addEvent(SetterEvent.settlerEvent());
		calendar.addEvent(SetterEvent.settlerEvent());
		calendar.addEvent(SetterEvent.settlerEvent());

		assertEquals(5, calendar.getEvents().size(), 0);
	}

	@Test
	public void testGetEventById() {
		Event event;
		event = calendar.getEventById(2);
		assertEquals(event, null);

		calendar.addEvent(SetterEvent.settlerEvent());
		calendar.addEvent(SetterEvent.settlerEvent());
		calendar.addEvent(SetterEvent.settlerEvent());
		calendar.addEvent(SetterEvent.settlerEvent());
		calendar.addEvent(SetterEvent.settlerEvent());

		Integer id = calendar.getEvents().get(4).getId();
		event = calendar.getEventById(id);
		assertEquals(id, event.getId(), 0);

		event = calendar.getEventById(null);
		assertEquals(event, null);
	}

	@Test
	public void testAddEvent() {
		Event event = SetterEvent.settlerEvent();

		calendar.addEvent(event.getInitial_date(), event.getFinal_date(), event.getName());
		assertEquals(1, calendar.getEvents().size(), 0);

		calendar.addEvent(null, null, event.getName());
		assertEquals(1, calendar.getEvents().size(), 0);
	}

	@Test
	public void testAddCompleteEvent() {
		Event event = SetterEvent.settlerEvent();

		calendar.addEvent(event);
		assertEquals(1, calendar.getEvents().size(), 0);

	}

	@Test
	public void testGetEventsByInterval() {
		Event event = SetterEvent.settlerEventWithoutDateValues();
		Calendar initial_date = Calendar.getInstance();
		Calendar final_date = Calendar.getInstance();

		calendar.addEvent(initial_date, final_date, event.getName());

		Calendar initial_date2 = Calendar.getInstance();
		Calendar final_date2 = Calendar.getInstance();

		initial_date2.add(Calendar.DATE, 2);
		final_date2.add(Calendar.DATE, 2);

		calendar.addEvent(initial_date2, final_date2, event.getName());
		calendar.addEvent(initial_date2, final_date2, event.getName());

		Calendar initial_date3 = Calendar.getInstance();
		Calendar final_date3 = Calendar.getInstance();

		initial_date3.add(Calendar.DATE, 4);
		final_date3.add(Calendar.DATE, 4);

		calendar.addEvent(initial_date3, final_date3, event.getName());
		calendar.addEvent(initial_date3, final_date3, event.getName());

		ArrayList<Event> events = calendar.getEventsByInterval(initial_date, final_date3);
		assertEquals(2, events.size(), 0);

		ArrayList<Event> events_2 = calendar.getEventsByInterval(null, final_date3);
		assertEquals(3, events_2.size(), 0);

		ArrayList<Event> events_3 = calendar.getEventsByInterval(initial_date, null);
		assertEquals(4, events_3.size(), 0);
	}

	@Test
	public void testGetEventsToday() {
		Event event = SetterEvent.settlerEventWithoutDateValues();
		Calendar initial_date = Calendar.getInstance();
		Calendar final_date = Calendar.getInstance();

		calendar.addEvent(initial_date, final_date, event.getName());

		Calendar initial_date2 = Calendar.getInstance();
		Calendar final_date2 = Calendar.getInstance();

		initial_date2.add(Calendar.DATE, 2);
		final_date2.add(Calendar.DATE, 2);

		calendar.addEvent(initial_date2, final_date2, event.getName());
		calendar.addEvent(initial_date2, final_date2, event.getName());

		Calendar initial_date3 = Calendar.getInstance();
		Calendar final_date3 = Calendar.getInstance();

		initial_date3.add(Calendar.DATE, 4);
		final_date3.add(Calendar.DATE, 4);

		calendar.addEvent(initial_date3, final_date3, event.getName());
		calendar.addEvent(initial_date3, final_date3, event.getName());

		ArrayList<Event> events = calendar.getEventsByToday();
		assertEquals(1, events.size(), 0);
	}

	@Test
	public void testGetEventsByPastDays() {
		Event event = SetterEvent.settlerEventWithoutDateValues();
		Calendar initial_date = Calendar.getInstance();
		Calendar final_date = Calendar.getInstance();

		initial_date.add(Calendar.DATE, 3);
		final_date.add(Calendar.DATE, 3);

		calendar.addEvent(initial_date, final_date, event.getName());

		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, 5);

		Calendar initial_date2 = Calendar.getInstance();
		Calendar final_date2 = Calendar.getInstance();

		initial_date2.add(Calendar.YEAR, 1);
		final_date2.add(Calendar.YEAR, 1);

		calendar.addEvent(initial_date2, final_date2, event.getName());
		calendar.addEvent(initial_date2, final_date2, event.getName());

		Calendar initial_date3 = Calendar.getInstance();
		Calendar final_date3 = Calendar.getInstance();

		initial_date3.add(Calendar.MONTH, 1);
		final_date3.add(Calendar.MONTH, 1);

		calendar.addEvent(initial_date3, final_date3, event.getName());
		calendar.addEvent(initial_date3, final_date3, event.getName());

		ArrayList<Event> events = calendar.getEventsByPastDays(2, today);
		assertEquals(1, events.size(), 0);
	}

	@Test
	public void testGetEventsTomorrow() {
		Event event = SetterEvent.settlerEventWithoutDateValues();
		Calendar initial_date = Calendar.getInstance();
		Calendar final_date = Calendar.getInstance();

		initial_date.add(Calendar.DATE, 1);
		final_date.add(Calendar.DATE, 1);

		calendar.addEvent(initial_date, final_date, event.getName());

		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, 5);

		Calendar initial_date2 = Calendar.getInstance();
		Calendar final_date2 = Calendar.getInstance();

		initial_date2.add(Calendar.YEAR, 1);
		final_date2.add(Calendar.YEAR, 1);

		calendar.addEvent(initial_date2, final_date2, event.getName());
		calendar.addEvent(initial_date2, final_date2, event.getName());

		Calendar initial_date3 = Calendar.getInstance();
		Calendar final_date3 = Calendar.getInstance();

		initial_date3.add(Calendar.MONTH, 1);
		final_date3.add(Calendar.MONTH, 1);

		calendar.addEvent(initial_date3, final_date3, event.getName());
		calendar.addEvent(initial_date3, final_date3, event.getName());

		ArrayList<Event> events = calendar.getEventsTomorrow();
		assertEquals(1, events.size(), 0);
	}

	@Test
	public void testUpdateEvent() {
		Event event = SetterEvent.settlerEventWithoutDateValues();
		Calendar initial_date = Calendar.getInstance();
		Calendar final_date = Calendar.getInstance();

		initial_date.add(Calendar.DATE, 1);
		final_date.add(Calendar.DATE, 1);

		calendar.addEvent(initial_date, final_date, event.getName());

		Event event_2 = SetterEvent.settlerEvent();

		boolean result = calendar.updateEvent(event_2.getId(), event_2.getInitial_date(), event_2.getFinal_date(),
				event_2.getName());
		assertTrue(result);

		event = calendar.getEventById(event.getId());
		assertEquals(event.getName(), event_2.getName());

		result = calendar.updateEvent(20, event_2.getInitial_date(), event_2.getFinal_date(), event_2.getName());
		assertFalse(result);
	}

	@Test
	public void testRemoveEvent() {
		Event event = SetterEvent.settlerEventWithoutDateValues();
		Calendar initial_date = Calendar.getInstance();
		Calendar final_date = Calendar.getInstance();

		initial_date.add(Calendar.DATE, 1);
		final_date.add(Calendar.DATE, 1);

		calendar.addEvent(initial_date, final_date, event.getName());

		Calendar initial_date2 = Calendar.getInstance();
		Calendar final_date2 = Calendar.getInstance();

		initial_date2.add(Calendar.YEAR, 1);
		final_date2.add(Calendar.YEAR, 1);

		calendar.addEvent(initial_date2, final_date2, event.getName());
		calendar.addEvent(initial_date2, final_date2, event.getName());

		boolean result = calendar.removeEventById(event.getId());
		assertTrue(result);

		assertEquals(2, calendar.getEvents().size(), 0);

		result = calendar.removeEventById(10);
		assertFalse(result);

		result = calendar.removeEventById(null);
		assertFalse(result);
	}

	/**
	 * Event tests
	 * 
	 */
	@Test
	public void testCreateValidEvent() {
		Event event = SetterEvent.settlerEvent();
		event.setInitial_date(Calendar.getInstance());
		event.setFinal_date(Calendar.getInstance());
		event.setName("New event");

		Assert.assertEquals(event.getName(), "New event");
	}

	@Test
	public void testCreateInvalidEventByInitialDateNull() {
		Event event = SetterEvent.settlerEventWithoutDateValues();
		event.setInitial_date(null);
		event.setFinal_date(Calendar.getInstance());
		event.setName("New event");

		Assert.assertEquals(event.getInitial_date(), null);
	}

	@Test
	public void testCreateInvalidEventByInitialDateValue() {
		Event event = SetterEvent.settlerEventWithoutDateValues();
		Calendar initial = Calendar.getInstance();
		initial.add(Calendar.DATE, -4);
		event.setInitial_date(initial);
		event.setFinal_date(Calendar.getInstance());
		event.setName("New event");

		Assert.assertEquals(event.getInitial_date(), null);
	}

	@Test
	public void testCreateInvalidEventByInitialDateCompareFinalDate() {
		Event event = SetterEvent.settlerEventWithoutDateValues();
		Calendar final_date = Calendar.getInstance();
		final_date.add(Calendar.DATE, 2);
		event.setFinal_date(final_date);

		Calendar initial = Calendar.getInstance();
		initial.add(Calendar.DATE, 4);
		event.setInitial_date(initial);
		event.setName("New event");

		Assert.assertEquals(event.getInitial_date(), null);
	}

	@Test
	public void testCreateInvalidEventByFinalDateNull() {
		Event event = SetterEvent.settlerEventWithoutDateValues();
		event.setFinal_date(null);
		event.setInitial_date(Calendar.getInstance());
		event.setName("New event");
		Assert.assertEquals(event.getFinal_date(), null);
	}

	@Test
	public void testCreateInvalidEventByFinalDateValue() {
		Event event = SetterEvent.settlerEventWithoutDateValues();
		Calendar final_date = Calendar.getInstance();
		final_date.add(Calendar.DATE, -4);
		event.setFinal_date(final_date);
		event.setInitial_date(Calendar.getInstance());
		event.setName("New event");

		Assert.assertEquals(event.getFinal_date(), null);
	}

	@Test
	public void testCreateInvalidEventByFinalDateCompareInitialDate() {
		Event event = SetterEvent.settlerEventWithoutDateValues();
		Calendar initial_date = Calendar.getInstance();
		initial_date.add(Calendar.DATE, 2);
		event.setInitial_date(initial_date);

		Calendar final_date = Calendar.getInstance();
		final_date.add(Calendar.DATE, 1);
		event.setFinal_date(final_date);
		event.setName("New event");

		Assert.assertEquals(event.getFinal_date(), null);
	}

	@Test
	public void lastTests() {
		Event event = SetterEvent.settlerEventWithoutDateValues();
		event.setCalendar(calendar);
		event.getCalendarProject();
		event.setId(2);
		event.getId();
	}

}
