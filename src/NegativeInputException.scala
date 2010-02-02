class NegativeInputException(badNumbers: Array[Int])
  extends Exception("negatives not allowed: " + badNumbers.map(
    (a) => a.toString).reduceLeft(
    (a, b) => a + ", " + b))
