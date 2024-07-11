package com.example.airplane_reservation.Repository;

import com.example.airplane_reservation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
