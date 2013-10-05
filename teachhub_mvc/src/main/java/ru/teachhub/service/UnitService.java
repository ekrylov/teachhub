package ru.teachhub.service;

import java.util.List;

import ru.teachhub.domain.Unit;

public interface UnitService
{

    List<Unit> findAll();

    Unit findById( Long id );

    List<Unit> findByTitle( String title );

}
