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
    input.replaceFirst("^//.*\n", "").split(separator(input)).map((a) => a.toInt)
  }

  private def separator(input: String) = {
    if (input startsWith("//")) {
      ";"
    } else {
      "[,\n]"
    }
  }

  private def addNumbers(numbers: Array[Int]) = {
    numbers.foldLeft(0) { (total, n) => total + n }
  }
}
