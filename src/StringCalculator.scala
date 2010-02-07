import scala.util.matching.Regex

object StringCalculator {
  def add(input: String) = {
    def extractNumbers(input: String) = {
      def removeHeader(input: String) = {
        input.replaceFirst("^//.*\n", "")
      }

      removeHeader(input).split(separator(input)).map((a) => a.toInt)
    }

    def separator(input: String) = {
      def customSeparator(input: String) = {
        val separatorRegex = "(?s)//(.).*".r
        val separatorRegex(separator) = input
        separator
      }

      if (input startsWith("//")) { customSeparator(input) } else { "[,\n]" }
    }

    def addNumbers(numbers: Array[Int]) = {
      def failOnNegativeNumbers(numbers: Array[Int]) = {
        val negatives = numbers.filter(n => n < 0)
        if (!negatives.isEmpty) {
          throw new NegativeInputException(negatives)
        }
      }

      def ignoreNumbersOver1000(numbers:Array[Int]) = {
        numbers.filter(n => n <= 1000)
      }

      failOnNegativeNumbers(numbers)
      ignoreNumbersOver1000(numbers).foldLeft(0) { (total, n) => total + n }
    }

    if (input isEmpty) {
      0
    } else {
      addNumbers(extractNumbers(input))
    }
  }
}
