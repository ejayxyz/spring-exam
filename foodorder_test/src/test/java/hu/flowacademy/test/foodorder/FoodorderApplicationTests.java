package hu.flowacademy.test.foodorder;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.flowacademy.test.foodorder.model.User;
import hu.flowacademy.test.foodorder.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodorderApplicationTests {

	@MockBean
	UserService userService;

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldCreateUser() throws Exception {
		User user = new User("robi", "mr robi", "szeged kiskacsa utca");

		
	}

}
