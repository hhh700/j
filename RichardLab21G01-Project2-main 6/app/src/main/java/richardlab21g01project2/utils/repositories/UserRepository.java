package richardlab21g01project2.utils.repositories;

import richardlab21g01project2.utils.entities.MyUser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.sql.*;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<MyUser, Long> {
    static final String DATABASE_PATH = Paths.get("src/main/resources/db", "accounts.db").toString();
    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    Optional<MyUser> findByUsername(String username);

    /**
     * Change account information
     */
    public static boolean change(String username, String property, String value) {
        return false;
    }

    public static List<String> getAccountByUsername(String username) {
        // String query = "SELECT name, id FROM my_user WHERE username LIKE \"%" + username + "%\"";
        // SQLiteDatabase db = this.getWritableDatabase();
        // Cursor cursorC = db.rawQuery(query, null);
        // while (cursorC.moveToNext()) {
        //     System.out.println(cursorC.getString(0) + " : " + cursorC.getString(1));
        // }
        return null;
    }

    public static List<String> getAccountByEmail(String email) {
        return null;
    }

    public static int getNextId() {
        return 0;
    }

    /**
     * Checks if an account has admin permissions
    */
    public static boolean isAdmin(String username) {
        List<String> userData = UserRepository.getAccountByUsername(username);
        if (userData == null) return false;
        else return userData.get(3).equals("ADMIN");
    }
}

