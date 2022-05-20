package com.example.catalogservice.repository;

import com.example.catalogservice.entity.Vaucher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VaucherRepositoryTest {


    @Autowired
    VaucherRepository vaucherRepository;


    @Test
    @Order(1)
    public void saveVaucher() {
        //testoviy
        Vaucher vaucher = Vaucher.builder().amount(1000).promoCode("Lochin").expireDate(new Date()).build();
        Vaucher test = Vaucher.builder().amount(2000).promoCode("Test").expireDate(new Date()).build();

        vaucherRepository.save(vaucher);
        vaucherRepository.save(test);
        Assertions.assertThat(vaucher.getId()).isGreaterThan(0);
        Assertions.assertThat(test.getId()).isGreaterThan(1);
    }

    @Test
    @Order(2)
    public void getAll() {

        //1-variant
//        Vaucher test = Vaucher.builder().amount(2000).promoCode("Test").expireDate(new Date()).build();
//        vaucherRepository.save(test);

        //2-variant
        saveVaucher();

        List<Vaucher> all = vaucherRepository.findAll();
        Assertions.assertThat(all.size()).isGreaterThan(0); //0 dan uzunligi
//        Assertions.assertThat(all.size()).isNotNull(); //size bo'sh bo'lmasa
    }

    @Test
    @Order(3)
    public void getOne() {

        Vaucher test = Vaucher.builder().amount(2000).promoCode("Test").expireDate(new Date()).build();
        vaucherRepository.save(test);

        Vaucher vaucher = vaucherRepository.findById(1).get();

        Assertions.assertThat(vaucher.getId()).isEqualTo(1);
    }

    @Test
    @Order(4)
    public void edit() {
//        saveVaucher();
        Vaucher test = Vaucher.builder().amount(2000).promoCode("Test").expireDate(new Date()).build();
        vaucherRepository.save(test);

        Vaucher vaucher = vaucherRepository.findById(1).get();

        vaucher.setPromoCode("Ketmon");
        Vaucher save = vaucherRepository.save(vaucher);

        Assertions.assertThat(save.getPromoCode()).isEqualTo("Ketmon");
    }

    @Test
    @Order(5)
    public void delete() {
        saveVaucher();

        Vaucher vaucher = vaucherRepository.findById(1).get();

        vaucherRepository.delete(vaucher);

        Vaucher edit = null;

        Optional<Vaucher> optionalVaucher = vaucherRepository.findByPromoCode("Lochin");

        if (optionalVaucher.isPresent()) {
            edit = optionalVaucher.get();
        }

        Assertions.assertThat(edit).isNull();
    }

}
