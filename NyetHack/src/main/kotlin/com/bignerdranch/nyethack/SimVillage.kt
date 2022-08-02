fun main() {
    val greetingFunction: (String) -> String = {
        val currentYear = 2019
        "Simvillage 방문을 환영합니다, $it 님! (copyRight $currentYear)"
    }
    println(greetingFunction("인치준"))
}
