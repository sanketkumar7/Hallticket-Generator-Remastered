package com.hallTicket.dao;

public interface HallticketOperation {

	boolean searchHallticket(String department, String year, String semester);

	boolean addhallticket(String department, String year, String semester, String[] subject, String[] theory,
			String[] practical, String[] oral);

	boolean updatehallticket(String department, String year, String semester, String[] subject, String[] theory,
			String[] practical, String[] oral);

	boolean deleteHallticket(String department, String year, String semester);
		
}
