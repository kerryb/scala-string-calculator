object StringCalculator {
  def add(input: String) = {
    if (input isEmpty) {
      0
    } else {
      val numbers = extractNumbers(input)
      addNumbers(numbers)
    }
  }

  private def extractNumbers(input: String) = {
    removeHeader(input).split(separator(input)).map((a) => a.toInt)
  }

  private def removeHeader(input: String) = {
    input.replaceFirst("^//.*\n", "")
  }

  private def separator(input: String) = {
    if (input startsWith("//")) { ";" } else { "[,\n]" }
  }

  private def addNumbers(numbers: Array[Int]) = {
    failOnNegativeNumbers(numbers)
    numbers.foldLeft(0) { (total, n) => total + n }
  }

  private def failOnNegativeNumbers(numbers: Array[Int]) = {
    val negatives = numbers.filter(n => n < 0)
    if (!negatives.isEmpty) {
      val errors = negatives.map((a) => a.toString).reduceLeft((a, b) => a + ", " + b)
      throw new NegativeInputException("negatives not allowed: " + errors)
    }
  }
}
