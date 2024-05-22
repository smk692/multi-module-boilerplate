package kr.co.kotlin.support.util.response

data class Response<T> private constructor(
    val data: T?,
    val message: String?,
    val status: String
) {
    companion object {
        fun <T> success(data: T): Response<T> {
            return Response(data, "정상", "success")
        }

        fun <T> fail(message: String? = null): Response<T> {
            return Response(null, message, "fail")
        }

        fun <T> error(message: String): Response<T> {
            return Response(null, message, "error")
        }
    }
}
