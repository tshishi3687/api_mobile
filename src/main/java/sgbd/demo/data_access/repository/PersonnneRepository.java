package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sgbd.demo.data_access.entity.Adresse;
import sgbd.demo.data_access.entity.Personne;

import java.util.List;
import java.util.Optional;

public interface PersonnneRepository extends JpaRepository<Personne, Integer> {
    Optional<Personne> findByNregistrenational(String nregistrenational);
    List<Personne> findAllByNompersonne(Personne personne);
    List<Personne> findAllByAdressepersonne_Cpostal(int adressepersonne);

    @Modifying
    @Query("update Personne u set u.nompersonne=?1, u.prenompersonne=?2, u.genrepersonne=?3, u.civilitepersonne=?4, u.adressepersonne=?5 where u.id=?6")
    void updatee(String nompersonne, String prenompersonne, String genrepersonne, String civilitepersonne, Adresse adressepersonne, int id);
}
