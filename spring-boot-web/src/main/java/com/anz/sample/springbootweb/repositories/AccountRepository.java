package com.anz.sample.springbootweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.sample.springbootweb.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{



}
