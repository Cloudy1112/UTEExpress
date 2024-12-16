package vn.iotstar.UTEExpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.Manager;

@Repository
public interface IManagerRepository extends JpaRepository<Manager, Integer>{
	// find manager bằng post id
	@Query("SELECT m FROM Manager m WHERE m.post.postID = :postID")
    Manager findManagerByIDPost(@Param("postID") Integer postID);
}
