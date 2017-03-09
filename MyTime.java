package by.epam.tr.lesson13;

import java.io.Serializable;
import java.util.Date;

public class MyTime implements Serializable {
	private static final long serialVersionUID = 3258714580692009125L;
	private Date date;

	public MyTime(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
