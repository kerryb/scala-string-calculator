object StringCalculator {
  def add(input: String) = {
    if (input isEmpty) {
      0
    } else {
      input.toInt
    }
  }
}
