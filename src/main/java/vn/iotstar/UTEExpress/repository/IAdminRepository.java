package vn.iotstar.UTEExpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}
