package com.carbcrest.carbc.Repositories;

import com.carbcrest.carbc.Entities.PeerDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface PeerDetailsRepository extends CrudRepository<PeerDetails, Integer> {


    @Modifying

    @Query(value = "INSERT INTO PeerDetails(node_id,ip, port, public_key)  VALUES (?1,?2,?3,?4)", nativeQuery = true)
    @Transactional
    void saveInPeerDetails(String node_id, String ip,String port,String public_key);

    @Query(value = "SELECT * FROM PeerDetails WHERE node_id= ?1", nativeQuery = true)
    PeerDetails findByNodeId(String node_id);



//
    @Query(value = "UPDATE PeerDetails SET ip = ?1, port = ?2 WHERE  node_id = ?3", nativeQuery = true)
    List<PeerDetails> updatePeer(String ip, int port, String node_id);


    @Query(value = "SELECT * FROM PeerDetails", nativeQuery = true)
    List<PeerDetails> getAllPeer();

//    @Query(value = "SELECT * FROM PeerDetails WHERE role= ?1", nativeQuery = true)
//    List<PeerDetails> findByNodeID(String address);
}
