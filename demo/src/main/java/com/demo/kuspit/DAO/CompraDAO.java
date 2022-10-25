package com.demo.kuspit.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.kuspit.modelo.Compra;
import com.demo.kuspit.modelo.User;

public interface CompraDAO extends CrudRepository<Compra,Long> {

	@Modifying
    @Transactional
    @Query("UPDATE Offer SET buy = ?1 WHERE id = ?2")
    void updateBuy(Boolean buy, Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Offer SET buyer = ?1 WHERE id = ?2")
    void updateBuyer(User buyer, Long id);

    @Query("SELECT r FROM Offer r WHERE r.user = ?1 ORDER BY r.id ASC ")
    Page<Compra> findAllByUser(Pageable pageable, User user);

    @Query("SELECT r FROM Offer r WHERE r.buyer = ?1 ORDER BY r.id ASC ")
    Page<Compra> findAllBoughtByUser(Pageable pageable, User user);

    @Query("SELECT r FROM Offer r WHERE r.user = ?1 ORDER BY r.id ASC ")
    List<Compra> findAllByUser(User user);

    @Query("SELECT r FROM Offer r WHERE r.user <> ?1 ORDER BY r.id ASC ")
    Page<Compra> findAllAvailableForUser(Pageable pageable, User user);

    @Query("SELECT r FROM Offer r WHERE (LOWER(r.title) LIKE LOWER(?1))")
    Page<Compra> searchByTitle(Pageable pageable, String seachtext);

    @Query("SELECT r FROM Offer r WHERE (LOWER(r.description) LIKE LOWER(?1) OR LOWER(r.user.name) LIKE LOWER(?1)) AND r.user = ?2 ")
    Page<Compra> searchByDescriptionNameAndUser(Pageable pageable, String seachtext, User user);

    @Query("SELECT r FROM Offer r WHERE (LOWER(r.title) LIKE LOWER(?1)) AND r.user <> ?2 ")
    Page<Compra> searchAvaiableByTitle(Pageable pageable, String seachtext, User user);

    Page<Compra> findAll(Pageable pageable);

    @Query("SELECT r FROM Offer r WHERE (LOWER(r.title) LIKE LOWER(?1)) AND r.buyer = ?2 ")
    Page<Compra> searchBoughtByTitle(Pageable pageable, String searchText, User user);
}
