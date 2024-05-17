import com.fasterxml.jackson.databind.ObjectMapper
import kr.co.kotlin.api.ApiApplication
import kr.co.kotlin.api.controller.user.api.UserController
import kr.co.kotlin.api.controller.user.request.UserCreateRequestDto
import kr.co.kotlin.api.controller.user.response.UserResponseDto
import kr.co.kotlin.domain.user.domain.User
import kr.co.kotlin.domain.user.service.UserCreatorDService
import kr.co.kotlin.domain.user.service.UserReaderDService
import kr.co.kotlin.support.util.response.Response
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@SpringBootTest(classes = [ApiApplication::class])
@AutoConfigureMockMvc
class UserControllerTest {

    @Mock
    private lateinit var userCreator: UserCreatorDService

    @Mock
    private lateinit var userReaderDService: UserReaderDService

    @InjectMocks
    private lateinit var userController: UserController

    @Autowired
    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build()
    }

    @Test
    fun `findUserById should return user`() {
        val id = 1L
        val user = User(id, "test", "test@test.com")
        `when`(userReaderDService.findByIdOrNull(id)).thenReturn(user)

        mockMvc.perform(get("/api/v1/users/${user.id}"))
            .andExpect(status().isOk)
            .andExpect(content().json(ObjectMapper().writeValueAsString(Response.success(UserResponseDto.fromDomain(user)))))
    }

    @Test
    fun `createUser should return success`() {
        val userCreateRequestDto = UserCreateRequestDto("test", "test@test.com")
        doNothing().`when`(userCreator).createUser(userCreateRequestDto.toDomain())

        mockMvc.perform(post("/api/v1/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(ObjectMapper().writeValueAsString(userCreateRequestDto)))
            .andExpect(status().isOk)
            .andExpect(content().json(ObjectMapper().writeValueAsString(Response.success(true))))
    }
}
