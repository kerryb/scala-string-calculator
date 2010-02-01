object StringCalculator {
  def add(input: String) = {
    if (input isEmpty) {
      0
    } else {
      val numbers = extractNumbers(input.replaceFirst("^//.*\n", ""), separator(input))
      addNumbers(numbers)
    }
  }

  private def separator(input: String) = {
    if (input startsWith("//")) {
      ";"
    } else {
      "[,\n]"
    }
  }

  private def extractNumbers(input: String, separator: String) = {
    input.split(separator).map((a) => a.toInt)
  }

  private def addNumbers(numbers: Array[Int]) = {
    numbers.foldLeft(0) { (total, n) => total + n }
  }
}
