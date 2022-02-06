package io.github.pabloin.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.pabloin.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/coffee/api")
@RestController
public class Swagger3RestController {

	List<User> users = new ArrayList<User>();
	{
		users.add(new User(1,"Pedro", "USER", "pedro@coffee-store.ar"));
		users.add(new User(2,"Sonia", "USER", "sonia@coffee-store.ar"));
		users.add(new User(2,"Raul", "USER", "raul@coffee-store.ar"));
		users.add(new User(4,"Clara", "SUPERVISOR", "clara@coffee-store.ar"));
		users.add(new User(5,"Mario", "ADMIN", "Mario@coffee-store.ar"));
	}


	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	public List<User> getUsers() {
		return users;
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	public User getUserById(@PathVariable(value = "id") int id) {
		return users.stream().filter(x -> x.getId()==(id))
				.collect(Collectors.toList()).get(0);
	}

	@RequestMapping(value = "/user/role/{role}", method = RequestMethod.GET, produces = "application/json")
	public List<User> getUserByRole(@PathVariable(value = "role") String role) {
		return users.stream().filter(x -> x.getRole().equalsIgnoreCase(role))
				.collect(Collectors.toList());
	}

}
