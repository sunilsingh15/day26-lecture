package sg.edu.nus.iss.day26lecture.services;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day26lecture.repositories.ShowsRepository;

@Service
public class ShowsServices {

    @Autowired
    private ShowsRepository repository;

    public List<Document> getShowsByName(String name) {
        return repository.findShowsByName(name);
    }
    
}
