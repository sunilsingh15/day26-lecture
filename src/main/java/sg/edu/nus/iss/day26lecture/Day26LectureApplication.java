package sg.edu.nus.iss.day26lecture;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.day26lecture.repositories.ShowsRepository;

@SpringBootApplication
public class Day26LectureApplication implements CommandLineRunner {

	@Autowired
	private ShowsRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Day26LectureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Document> docs = repository.findShowsByName("How I Met Your Mother");

		for (Document d : docs) {
			String name = d.getString("name");
			String type = d.getString("type");
			Integer runtime = d.getInteger("runtime");

			// Get average rating
			Document ratingsDoc = d.get("rating", Document.class);
			Double avg = ratingsDoc.getDouble("average");

			// returning the JSON array as a list of String
			List<String> genres = d.getList("genres", String.class);
			
			System.out.printf("title: %s, type: %s, runtime: %d, rating: %.2f\n", name, type, runtime, avg);
			System.out.printf("\tgenres: %s\n", genres);
		}
	}

}
