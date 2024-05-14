package kr.co.kotlin.api.support.error


import kr.co.kotlin.boilerplate.infrastructure.util.response.ApiResponse
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {
    private val logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(Exception::class)
    fun handleUnknownException(e: Exception): ApiResponse<Unit> {
        logger.error(e.message, e)
        return ApiResponse.error("서버에서 알 수 없는 에러가 발생했습니다.")
    }
}
