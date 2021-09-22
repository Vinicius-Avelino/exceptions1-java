package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {

		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); // subtrai as datas pelos milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Converte o que está em milissegundos para dias

	}

	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now))
		{
			return "Error in reservation dates for updates must be future dates";
		}
		if (!checkOut.after(checkIn)) //checa se a data de checkout é inferior que a de checkin
		{
			return  "Error in reservation: Check-out date mut be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null; //Se retornar nenhum nulo é porque não teve erro
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}

}
