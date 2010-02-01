object StringCalculator {
  def add(input: String) = {
    if (input isEmpty) {
      0
    } else {
      val separator = if (input startsWith("//")) {
        ";"
      } else {
        "[,\n]"
      }
      val numbers = extractNumbers(input.replaceFirst("^//.*\n", ""), separator)
      addNumbers(numbers)
    }
  }

  private def extractNumbers(input: String, separator: String) = {
    input.split(separator).map((a) => a.toInt)
  }

  private def addNumbers(numbers: Array[Int]) = {
    numbers.foldLeft(0) { (total, n) => total + n }
  }
}
