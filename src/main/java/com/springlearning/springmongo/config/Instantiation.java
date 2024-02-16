package com.springlearning.springmongo.config;

import com.springlearning.springmongo.domain.Post;
import com.springlearning.springmongo.domain.User;
import com.springlearning.springmongo.dto.AuthorDTO;
import com.springlearning.springmongo.repositories.PostRepository;
import com.springlearning.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        //clear db
        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Alex Green", "alex@gmail.com");
        User u3 = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Post p1 = new Post(null, sdf.parse("21/10/2020"), "Wow title", "Very body", new AuthorDTO(u1));
        Post p2 = new Post(null, sdf.parse("21/10/2020"), "Wow title", "Very body", new AuthorDTO(u1));
        postRepository.saveAll(Arrays.asList(p1, p2));

        u1.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(u1);

    }
}
