package es.deusto.spq.client.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;

public class JCalendarioTest {

	JCalendario jCalendar;
	
	@Rule 
	public ContiPerfRule i = new ContiPerfRule();

    @Before
    public void setUp() throws Exception {
        jCalendar = new JCalendario();
    }

    @After
    public void tearDown() throws Exception {
        jCalendar = null;
    }

    @Test
    public void testDateConstructor() {
        jCalendar = new JCalendario((Date) null); // null date
        assertTrue(jCalendar.getDate() != null);

        Date date = new Date();
        jCalendar = new JCalendario(date);
        assertEquals(date, jCalendar.getDate());
    }

    @Test
    public void testSetGetDate() {
        Date[] tests = { new Date() };

        for (int i = 0; i < tests.length; i++) {
            jCalendar.setDate(tests[i]);
            assertEquals(tests[i], jCalendar.getDate());
        }
    }

    @Test(expected = NullPointerException.class)
    public void testSetDateNull() {
        jCalendar.setDate(null);
    }

    @Test
    public void testSetGetCalendar() throws Exception {
        Calendar[] tests = { Calendar.getInstance() };

        for (int i = 0; i < tests.length; i++) {
            jCalendar.setCalendar(tests[i]);
            assertEquals(tests[i], jCalendar.getCalendar());
        }
    }

    @Test(expected = NullPointerException.class)
    public void testSetCalendarNull() throws Exception {
        jCalendar.setCalendar(null);
    }

    @Test
    public void testSetIsEnabled() throws Exception {
        boolean[] tests = { true, false };

        for (int i = 0; i < tests.length; i++) {
            jCalendar.setEnabled(tests[i]);
            assertEquals(tests[i], jCalendar.isEnabled());
        }
    }

    @Test
    public void testAddPropertyChangeListener() throws Exception {
        class MyListener implements PropertyChangeListener {
            boolean called = false;

            public void propertyChange(PropertyChangeEvent event) {
                called = true;
            }
        }
        MyListener listener = new MyListener();
        JCalendario dateChooser = new JCalendario();
        dateChooser.addPropertyChangeListener("date", listener);
        dateChooser.setDate(new Date());
        assertTrue("Listener was not called", listener.called);

        dateChooser.removePropertyChangeListener("date", listener);
        dateChooser.addPropertyChangeListener(listener);
        listener.called = false;
        dateChooser.setDate(new Date(System.currentTimeMillis() - 100));
        assertTrue("Listener was not called", listener.called);
    }

    @Test
    public void testRemovePropertyChangeListener() throws Exception {
        class MyListener implements PropertyChangeListener {
            boolean called = false;

            public void propertyChange(PropertyChangeEvent event) {
                called = true;
            }
        }
        MyListener listener = new MyListener();
        JCalendario dateChooser = new JCalendario();
        dateChooser.addPropertyChangeListener(listener);
        dateChooser.removePropertyChangeListener(listener);
        dateChooser.addPropertyChangeListener("date", listener);
        dateChooser.removePropertyChangeListener("date", listener);
        dateChooser.setDate(new Date());
        assertFalse("Listener was called", listener.called);
    }

    @Test
    public void testLocale() {
        Locale testLocale = Locale.ENGLISH;
        jCalendar = new JCalendario(testLocale);
        Locale monthChooserLocale = jCalendar.getMonthChooser().getLocale();
        assertEquals(testLocale, monthChooserLocale);
        Locale dayChooserLocale = jCalendar.getDayChooser().getLocale();
        assertEquals(testLocale, dayChooserLocale);
    }

    public static void main(String... args) {
        junit.textui.TestRunner.run(suite());
    }

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(JCalendarioTest.class);
    }
}
