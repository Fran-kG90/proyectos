package com.demo.kuspit.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.demo.kuspit.DAO.CompraDAO;
import com.demo.kuspit.modelo.Compra;
import com.demo.kuspit.modelo.User;

@Service
public class CompraService {

    @Autowired
    private CompraDAO offersRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private RolesService rolesService;

    @Autowired
    private UsersService usersService;

    public Page<Compra> getOffers(Pageable pageable) {
        Page<Compra> offers = offersRepository.findAll(pageable);
        return offers;
    }

    public Compra getOffer(Long id) {
        Set<Compra> consultedList = (Set<Compra>) httpSession.getAttribute("consultedList");
        if (consultedList == null)
            consultedList = new HashSet<Compra>();
        Compra offerObtained = offersRepository.findById(id).get();
        consultedList.add(offerObtained);
        httpSession.setAttribute("consultedList", consultedList);
        return offerObtained;
    }

    public List<Compra> getOffersForUser(User user) {
        return offersRepository.findAllByUser(user);
    }

    public Page<Compra> getBoughtOffers(Pageable pageable, User user) {
        return offersRepository.findAllBoughtByUser(pageable, user);
    }

    public Page<Compra> getOffersAvailableForUser(Pageable pageable, User user) {
        Page<Compra> offers;
        if (user.getRole().equals(rolesService.getRoles()[0])) {
            offers = offersRepository.findAllAvailableForUser(pageable, user);
        } else {
            offers = getOffers(pageable);
        }
        return offers;
    }

    public Page<Compra> searchOffersAvaiableByTitle(Pageable pageable, String searchText, User user) {
        Page<Compra> offers = new PageImpl<Compra>(new ArrayList<Compra>());
        searchText = "%" + searchText + "%";
        if (user.getRole().equals(rolesService.getRoles()[0])) {
            offers = offersRepository.searchAvaiableByTitle(pageable, searchText, user);
        } else {
            offers = offersRepository.searchByTitle(pageable, searchText);
        }
        return offers;
    }

    public Page<Compra> searchOffersBoughtByTitleForUser(Pageable pageable, String searchText, User user) {
        Page<Compra> offers;
        searchText = "%" + searchText + "%";
        offers = offersRepository.searchBoughtByTitle(pageable, searchText, user);
        return offers;
    }

    public void setOfferBuy(boolean buy, Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User buyer = usersService.getUserByEmail(email);
        Compra offer = offersRepository.findById(id).get();
        if (offer.getUser().getEmail().equals(email))
            return;
        offersRepository.updateBuy(buy, id);
        if (buy)
            offersRepository.updateBuyer(buyer, id);
        else
            offersRepository.updateBuyer(null, id);
    }

    public void addOffer(Compra offer) {
        offersRepository.save(offer);
    }

    public void deleteOffer(Long id) {
        offersRepository.deleteById(id);
    }

}
