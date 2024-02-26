package com.arturrdc.issuescoutbackend.ticket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        return ticketRepository.findById(id).map(ticket -> {
            ticket.setTitle(ticketDetails.getTitle());
            ticket.setDescription(ticketDetails.getDescription());
            ticket.setType(ticketDetails.getType());
            ticket.setPriority(ticketDetails.getPriority());
            ticket.setDifficulty(ticketDetails.getDifficulty());
            ticket.setAssignedTo(ticketDetails.getAssignedTo());
            ticket.setSubmittedBy(ticketDetails.getSubmittedBy());
            ticket.setStatus(ticketDetails.getStatus());
            ticket.setLastUpdated(ticketDetails.getLastUpdated());
            ticket.setCreatedAt(ticketDetails.getCreatedAt());
            return ticketRepository.save(ticket);
        }).orElseThrow(() -> new RuntimeException("Ticket not found with id " + id));
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}

