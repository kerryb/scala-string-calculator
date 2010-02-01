object StringCalculator {
  def add(input: String) = {
    if (input isEmpty) {
      0
    } else {
      input.split(",").map(
        (a) => a.toInt).reduceLeft(
        (a, b) => a + b)
    }
  }
}
