package com.tss.webapps.happy.birthday.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tss.webapps.happy.birthday.api.entities.Mensagem;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

}
