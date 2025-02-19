package richardlab21g01project2.test;

import richardlab21g01project2.utils.entities.MyUser;
import richardlab21g01project2.utils.entities.Scroll;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;



public class EntitiesTest {
    ZonedDateTime current_time = ZonedDateTime.now();
    String current_time_str = current_time.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);

    @Test
    void testMyUserEntity() {
        MyUser user = new MyUser();

        user.setUsername("username");
        assertEquals("username", user.getUsername());

        user.setPassword("password");
        assertEquals("password", user.getPassword());

        user.setRole("USER");
        assertEquals("USER", user.getRole());

        user.setId(1L);
        assertEquals(1L, user.getId());

        user.setEmail("user0000@uni.sydney.edu.au");
        assertEquals("user0000@uni.sydney.edu.au", user.getEmail());
        
        user.setPhoneNumber(727000727L);
        assertEquals(727000727L, user.getPhoneNumber());

        user.setFirstName("Richard");
        assertEquals("Richard", user.getFirstName());
        
        user.setLastName("Waterson");
        assertEquals("Waterson", user.getLastName());

        user.setAddress("Sydney, Sustralia");
        assertEquals("Sydney, Sustralia", user.getAddress());

        user.setCreationDate(current_time);
        assertEquals(current_time, user.getCreationDate());
        user.setCreationDate(current_time_str);
        assertEquals(current_time, user.getCreationDate());
    }

    @Test
    void testScrollEntity() {
        Scroll scroll = new Scroll();

        // However you test UUID, idk
        // scroll.setScrollId();
        // assertEquals(, scroll.getScrollId());

        scroll.setName("Scroll 1");
        assertEquals("Scroll 1", scroll.getName());

        // Plus the rest
    }
}