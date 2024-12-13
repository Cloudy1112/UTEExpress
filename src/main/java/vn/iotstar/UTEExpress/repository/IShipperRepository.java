package vn.iotstar.UTEExpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.Shipper;

@Repository
public interface IShipperRepository extends JpaRepository<Shipper, Integer>{
	@Query("SELECT s FROM Shipper s WHERE s.post.postID = :postID")
	List<Shipper> findShippersByIDPost(@Param("postID") Integer postID);
}
