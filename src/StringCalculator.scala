object StringCalculator {
  private val separatorRegex = "[,\n]"
  def add(input: String) = {
    if (input isEmpty) {
      0
    } else {
      val numbers = input.split(separatorRegex).map((a) => a.toInt)
      addNumbers(numbers)
    }
  }

  private def addNumbers(numbers: Array[Int]) = {
    numbers.foldLeft(0) { (total, n) => total + n }
  }
}
