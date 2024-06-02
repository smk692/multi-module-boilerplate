package kr.co.kotlin.domain.alert.event

data class SlackErrorSenderEvent(
    val url:String,
    val block: Map<String, List<String>>,
)
