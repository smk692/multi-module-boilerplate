package kr.co.kotlin.domain.alert.event

data class SlackDmSenderEvent(
    val blocks: Map<String, List<String>>,
    val emails: List<String>,
    val currentUserEmail: String,
)
