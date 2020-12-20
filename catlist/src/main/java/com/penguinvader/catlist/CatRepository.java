package com.penguinvader.catlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.penguinvader.catlist.Cat;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {

}
