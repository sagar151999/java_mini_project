package com.model;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class AmusementPark 
{
	private String name;
//  private Tickets[] ticketsarry = new Tickets[10];
//  private Merchandise[] merchandise = new Merchandise[10]; 
	private Vector<Ticket> tickets = new Vector<Ticket>();
	private Vector<Merchandise> merchandise = new Vector<Merchandise>();
	private Vector<Ticket> avilableTickets = new Vector<>();
	private Vector<Ticket> bookedTickets = new Vector<>();
	private Vector<Merchandise> availableMerchandise = new Vector<>();
	private Vector<Merchandise> purchasedMerchandise = new Vector<>();
	private int ticketCount = 0;
	private int merchandiseCount = 0;

//  public void printVector() {
//  	for(Tickets v:tickets) {
//      	System.out.println(v.getTicket());
//      }
//
//  }
	public AmusementPark(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public Date[] getTicketDates() {
		Date[] dates = new Date[ticketCount];
		for (int i = 0; i < ticketCount; i++) {
			dates[i] = tickets.get(i).getDate();
		}
		return dates;
	}

	public int getTickets(Date date) {
		int count = 0;
		for (int i = 0; i < ticketCount; i++) {
			if (tickets.get(i).getDate().equals(date)) {
				count++;
			}
		}
		return count;
	}

	public void bookTicket(long id, String name) {
		for (Ticket ticket : avilableTickets) {
			if (ticket.getTicket() == id) {
				System.out.println("Ticket price: " + ticket.getPrice());
				ticket.setAvalabilty("Unavilable");
				ticket.setHolder(name);
				bookedTickets.add(ticket);
				avilableTickets.remove(ticket);
				break;
			}
		}
	}

	public Vector<Ticket> bookedTickets() {
		return bookedTickets;
	}

	public Vector<Ticket> getTickets() {

		return avilableTickets;
	}

	public Ticket getTicket(long id) {

		for (Ticket ticket : avilableTickets) {
			if (ticket.getTicket() == id) {
				return ticket;
			}

		}
		return null;
	}

	public Vector<Merchandise> getMerchandise(String category) {
		Vector<Merchandise> matching = new Vector<Merchandise>();
		for (Merchandise merchandise : availableMerchandise) {
			if (merchandise.getCategory().equals(category)) {
				matching.add(merchandise);
			}
		}
		return matching;
	}

	public Merchandise getMerchandise(long id) {
		for (Merchandise merchandises : availableMerchandise) {
			if (merchandises.getId() == id) {
				return merchandises;
			}

		}
		return null;
	}

	public void addMerchandise2(Merchandise mer) {
		availableMerchandise.add(mer);
	}

	public Vector<Merchandise> getMerchandises() {

		return availableMerchandise;
	}

	public Vector<Merchandise> purchasedMerchandises() {
		return purchasedMerchandise;
	}

	public void addTicket(Ticket ticket) {
		avilableTickets.add(ticket);
	}

	public void addExtraTicket(Ticket ticket) {
		avilableTickets.add(ticket);
	}

	public void addMerchandise(Merchandise item) {

		availableMerchandise.add(item);
	}

	public void buyMerchandise(long id) {
		for (Merchandise md : availableMerchandise) {
			if (md.getId() == id) {
				purchasedMerchandise.add(md);
				availableMerchandise.remove(md);
				break;
			}
		}
	}
	}