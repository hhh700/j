package richardlab21g01project2.utils.repositories;

import richardlab21g01project2.utils.entities.MyUser;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByUsername(String username);
    Optional<MyUser> findByEmail(String email);
    // Optional<MyUser> findById(Long id);

    // /**
    //  * Checks if an account has admin permissions
    // */
    // public static boolean isAdmin(String username) {
    //     List<String> userData = UserRepository.findByUsername(username);
    //     if (userData == null) return false;
    //     else return userData.get(3).equals("ADMIN");
    // }
}

