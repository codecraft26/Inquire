package dev.aman.inquire.utils

object Constants {
    val listOfLanguages = listOf(
        "C",
        "C++",
        "Go",
        "HTML/CSS",
        "Java",
        "JavaScript",
        "Kotlin",
        "Python",
        "Ruby",
        "Rust",
        "Scala",
        "Swift",
        "TypeScript",
        "Android",
        "Kotlin",
        "React-Native",
        "Flutter",
        "Dart",
        "Elixir",
        "Elastcic",
        "Machine Learning"
    )
    const val KEY_INPUT_CODE_DIALOG = "key_input_code_dialog"

    const val KEY_CODE = "key_code"
    const val KEY_PUBLISHED_FIRST_SNIPPET = "key_published_first_Inquire"

    const val KEY_USER_PREFERRED_TAGS = "user_preferred_tags"
    const val KEY_USER = "shared_pref_user"
}
enum class InquireState{
    Bookmarked,UnBookmarked
}