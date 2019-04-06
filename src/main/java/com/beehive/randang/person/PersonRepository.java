package com.beehive.randang.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {
}
