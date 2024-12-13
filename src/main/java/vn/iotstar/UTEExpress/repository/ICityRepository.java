package vn.iotstar.UTEExpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.City;

@Repository
public interface ICityRepository extends JpaRepository<City, Integer>{

}
