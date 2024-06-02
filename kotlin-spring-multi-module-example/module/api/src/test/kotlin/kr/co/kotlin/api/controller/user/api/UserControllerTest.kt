import com.fasterxml.jackson.databind.ObjectMapper
import kr.co.kotlin.api.ApiApplication
import kr.co.kotlin.api.controller.user.api.UserController
import kr.co.kotlin.api.controller.user.application.UserService
import kr.co.kotlin.api.controller.user.request.UserUpdateRequestDto
import kr.co.kotlin.api.controller.user.response.UserResponseDto
import kr.co.kotlin.domain.user.model.User
import kr.co.kotlin.support.util.response.Response
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@SpringBootTest(classes = [ApiApplication::class])
@AutoConfigureMockMvc
class UserControllerTest {

    @Mock
    private lateinit var userService: UserService

    @InjectMocks
    private lateinit var userController: UserController

    @Autowired
    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build()
    }

    @Test
    fun `사용자 ID로 사용자를 찾으면 사용자가 반환된다`() {
        val id = 1L
        val user = User(id, "test", "test@test.com")
        `when`(userService.findUserById(id)).thenReturn(user)

        // when & then
        mockMvc.perform(get("/api/v1/users/${user.id}"))
            .andExpect(status().isOk)
            .andExpect(content().json(ObjectMapper().writeValueAsString(Response.success(UserResponseDto.fromDomain(user)))))
    }

    @Test
    fun `사용자 업데이트가 성공할 때`() {
        val id = 1L
        val userUpdateRequestDto = UserUpdateRequestDto("updatedTest")

        // given
        given(userService.updateUser(id, userUpdateRequestDto)).willReturn(0)

        // when & then
        mockMvc.perform(put("/api/v1/users/$id")
            .contentType(MediaType.APPLICATION_JSON)
            .content(ObjectMapper().writeValueAsString(userUpdateRequestDto)))
            .andExpect(status().isOk)
            .andExpect(content().json(ObjectMapper().writeValueAsString(Response.success(0))))

        verify(userService).updateUser(id, userUpdateRequestDto)
    }

    @Test
    fun `사용자가 존재하지 않을 때 업데이트 실패`() {
        val id = 1L
        val userUpdateRequestDto = UserUpdateRequestDto("updatedTest")
        `when`(userService.updateUser(id, userUpdateRequestDto)).thenThrow(IllegalArgumentException())

        mockMvc.perform(put("/api/v1/users/$id")
            .contentType(MediaType.APPLICATION_JSON)
            .content(ObjectMapper().writeValueAsString(userUpdateRequestDto)))
            .andExpect(status().isNotFound)
    }

    @Test
    fun `요청 본문이 유효하지 않을 때 업데이트 실패`() {
        val id = 1L
        val userUpdateRequestDto = UserUpdateRequestDto("")

        mockMvc.perform(put("/api/v1/users/$id")
            .contentType(MediaType.APPLICATION_JSON)
            .content(ObjectMapper().writeValueAsString(userUpdateRequestDto)))
            .andExpect(status().isBadRequest)
    }
}
