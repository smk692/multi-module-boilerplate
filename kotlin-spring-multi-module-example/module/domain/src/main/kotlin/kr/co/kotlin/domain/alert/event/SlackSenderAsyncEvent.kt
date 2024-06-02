package kr.co.kotlin.domain.alert.event

data class SlackSenderAsyncEvent(
    val url: String,
    val blocks: Map<String, List<String>>,
) {

}
