package global.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global.entities.User;
import global.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Usúario não encontrado id:" + id));
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User user) {
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Não foi possivel encotrar este id:" + id));

		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());

		return userRepository.save(existingUser);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
