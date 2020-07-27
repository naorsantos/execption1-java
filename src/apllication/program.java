package apllication;

import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do Quarto:");
		int number = sc.nextInt();
		System.out.print("Check- in date  (dd/MM/yyyy):");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check- out date  (dd/MM/yyyy):");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Check-out deve ser depois da data de Check-in");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation:" + reservation);

			System.out.println();
			System.out.println("Entre com a data para atualizar a reserva:");
			System.out.print("Check- in date  (dd/MM/yyyy):");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check- out date  (dd/MM/yyyy):");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
			System.out.println("Erro na reserva:" + error);
			}
			else {	
			System.out.println("Reservation:" + reservation);
				
				}
			}
			sc.close();

		}

	}

