object StringCalculator {
  def add(input: String) = {
    if (input isEmpty) {
      0
    } else {
      val numbers = input.split(",").map((a) => a.toInt)
      addNumbers(numbers)
    }
  }

  private def addNumbers(numbers: Array[Int]) = {
    numbers.foldLeft(0) { (total, n) => total + n }
  }
}
