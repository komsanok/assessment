package com.kbtg.bootcamp.posttest.repositories;

import com.kbtg.bootcamp.posttest.entities.UserTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTicketRepository extends JpaRepository<UserTicket,Long> {
}
