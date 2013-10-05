package ru.teachhub.service;

import java.util.List;

import ru.teachhub.domain.Tag;

public interface TagService
{

    List<Tag> findAll();

    List<Tag> findByTitle( String title );

}
