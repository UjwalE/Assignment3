/**
 * 
 */
package com.skillspeed.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.skillspeed.entity.Movie;

/**
 * @author Nephilim
 *
 */
public class MovieService {
	
	
	public MovieService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Session getSession(){
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistryBuilder srBuilder = new ServiceRegistryBuilder();
		srBuilder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = srBuilder.buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		return factory.openSession();
 }

	public void addMovie(Session session, Movie movie) {
		// TODO Auto-generated method stub
		session.save(movie);
		
	}

	public void getAllMovies(Session session) {
		// TODO Auto-generated method stub
		List<Movie> movies = session.createQuery("from Movie").list();
		showList(movies);
		
	}

	public Movie getMovieByName(Session session, String title) {
		
		Query query = session.createQuery("from Movie m "
				+"where m.title=:title");
		query.setString("title", title);
		return (Movie)query.uniqueResult();
				
	}

	public void defaultData(Session session) {
		// TODO Auto-generated method stub
		Movie movie1 = new Movie();
		movie1.setTitle("Kiladi 786");
		movie1.setDirector("Himesh Rehsamiya");
		movie1.setSynopsis("Bekaar");
		addMovie(session,movie1);
		
		Movie movie2 = new Movie();
		movie2.setTitle("Batman Returns");
		movie2.setDirector("Christopher Nolan");
		movie2.setSynopsis("Awesome");
		addMovie(session,movie2);
		
		Movie movie3 = new Movie();
		movie3.setTitle("Housefull");
		movie3.setDirector("Sajid");
		movie3.setSynopsis("Disaster");
		addMovie(session,movie3);
	}
	
	private static void showList(List<Movie> list) {
		// TODO Auto-generated method stub
		System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.printf("%-22s%-22s%-22s\n","Title","Director","Wynopsis");
		
		for (Movie item : list) {
			System.out.printf("%-22s%-22s%-22s\n",
					item.getTitle(),item.getDirector(),item.getSynopsis());
		}
		
	}

	public void diplay(Movie film) {
		// TODO Auto-generated method stub
		
		System.out.println("Title: " + film.getTitle());
		System.out.println("Directed by: " + film.getDirector());
		System.out.println("Synopsis: " + film.getSynopsis());
		
	}

}
