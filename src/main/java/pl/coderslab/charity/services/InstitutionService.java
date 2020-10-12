package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InstitutionService {

    private InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository){
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> findAllInstitution(){
        return institutionRepository.findAll();
    }

    public void addInstitution(Institution institution){
        institutionRepository.save(institution);
    }

    public Institution findInstitutionById(Long id){
        return institutionRepository.findById(id).get();
    }

    public void deleteInstitution(Institution institution){
         institutionRepository.delete(institution);
    }
}
