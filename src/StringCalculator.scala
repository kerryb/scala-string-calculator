object StringCalculator {
  private val separatorRegex = "[,\n]"
  def add(input: String) = {
    if (input isEmpty) {
      0
    } else {
      val numbers = extractNumbers(input)
      addNumbers(numbers)
    }
  }

  private def extractNumbers(input: String) = {
    input.split(separatorRegex).map((a) => a.toInt)
  }

  private def addNumbers(numbers: Array[Int]) = {
    numbers.foldLeft(0) { (total, n) => total + n }
  }
}
