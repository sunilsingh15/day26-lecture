package sg.edu.nus.iss.day26lecture.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ShowsRepository {

    public static final String C_TV_SHOWS = "tv-shows";
    public static final String F_NAME = "name";

    @Autowired
    private MongoTemplate template;

    /*
     * db.tv-shows.find({name: 'the program name'})
     */

    public List<Document> findShowsByName(String programName) {
        // Set the filter
        Criteria criteria = Criteria.where(F_NAME).is(programName);

        // Create a Mongo query with the filter
        Query query = Query.query(criteria);

        // Perform the query
        return template.find(query, Document.class, C_TV_SHOWS);
    }
     
}
