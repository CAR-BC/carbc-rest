package com.carbcrest.carbc.Repositories;

import com.carbcrest.carbc.Entities.PeerDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeerDetailsRepository extends CrudRepository<PeerDetails, Integer> {

    @Query(value = "SELECT * FROM PeerDetails WHERE node_id= ?1", nativeQuery = true)
    PeerDetails findByNodeId(String node_id);



//
    @Query(value = "UPDATE PeerDetails SET ip = ?1, port = ?2 WHERE  node_id = ?3;", nativeQuery = true)
    List<PeerDetails> updatePeer(String ip, int port, String node_id);

//    @Query(value = "SELECT * FROM PeerDetails WHERE role= ?1", nativeQuery = true)
//    List<PeerDetails> findByNodeID(String address);
}
