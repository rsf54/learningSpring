package com.crm.crm.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class ContactRepository implements CrudRepository<Contact, Long> {

    @Override
    public <S extends Contact> S save(S s) {
        return null;
    }

    @Override
    public <S extends Contact> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Contact> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Contact> findAll() {
        return null;
    }

    @Override
    public Iterable<Contact> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Contact contact) {

    }

    @Override
    public void deleteAll(Iterable<? extends Contact> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
