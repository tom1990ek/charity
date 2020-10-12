package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("select sum(d.quantity) from Donation d")
    Integer findSumOfBags ();

    @Query("select count (d.id) from Donation d")
    Integer findSumOfDonation ();

    @Override
    <S extends Donation> S save(S s);

}
