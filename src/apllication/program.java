package apllication;

import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.execptions.DomainExecption;

public class program {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
		System.out.print("Numero do Quarto:");
		int number = sc.nextInt();
		System.out.print("Check- in date  (dd/MM/yyyy):");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check- out date  (dd/MM/yyyy):");
		Date checkOut = sdf.parse(sc.next());

	
		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println("Reservation:" + reservation);

		System.out.println();
		System.out.println("Entre com a data para atualizar a reserva:");
		System.out.print("Check- in date  (dd/MM/yyyy):");
		checkIn = sdf.parse(sc.next());
		System.out.print("Check- out date  (dd/MM/yyyy):");
		checkOut = sdf.parse(sc.next());

		 reservation.updateDates(checkIn, checkOut);
		 System.out.println("Reservation:" +reservation);
		}
		catch(ParseException e) {
			System.out.println("Formato da data Errado");
		}
		catch (DomainExecption e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro Inesperado.");
		}
		sc.close();

		}

	}

