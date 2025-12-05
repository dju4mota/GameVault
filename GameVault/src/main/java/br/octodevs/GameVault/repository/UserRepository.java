package br.octodevs.GameVault.repository;

import br.octodevs.GameVault.model.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
