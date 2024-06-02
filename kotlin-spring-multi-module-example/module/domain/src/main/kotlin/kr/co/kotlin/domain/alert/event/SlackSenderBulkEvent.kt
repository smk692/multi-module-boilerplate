package kr.co.kotlin.domain.alert.event

class SlackSenderBulkEvent(
    val url: String,
    val messages: List<SlackSenderAsyncEvent>
) {
}
