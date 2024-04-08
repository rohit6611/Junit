package com.altruist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.altruist.user.User;
import com.altruist.user.UserRepository;
import com.altruist.user.UserService;


public class ServiceTest {

	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepo;
	
	static List<User> user=new ArrayList<>();
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		user.add(new User(1L,"ram","tech"));
		user.add(new User(2L,"shyam","tech"));
		
		
		Mockito.when(userRepo.findAll()).thenReturn(user);
	}
	
	@Test
	@Disabled
	public void test() {
		List<User> list = userRepo.findAll();
		
		assertEquals("ram",user.get(0).getName());
	}
	
//	@ParameterizedTest(name = "{0} toUpperCase is {1}")
//	@CsvSource(value = { "abcd, ABCD", "abc, ABC", "'',''", "abcdefg, ABCDEFG" })
//	void uppercase(String word, String capitalizedWord) {
//		assertEquals(capitalizedWord, word.toUpperCase());
//	}
	
	@Test
	@DisplayName("When length is null, throw an exception")
	void length_exception() {

		String str = null;

		assertThrows(NullPointerException.class,

				() -> {
					str.length();
				}

		);
	}
}
