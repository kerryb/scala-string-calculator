import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class StringCalculatorSpec extends Spec with ShouldMatchers {
  describe("StringCalculator") {
    it("calculates the sum of an empty string as 0") {
      StringCalculator.add("") should equal(0)
    }

    it("calculates the sum of a single number as itself") {
      StringCalculator.add("1") should equal(1)
    }

    it("calculates the sum of two numbers") {
      StringCalculator.add("1,41") should equal(42)
    }

    it("calculates the sum of many numbers") {
      StringCalculator.add("1,2,3,4,5") should equal(15)
    }

    it("allows newline-separated numbers") {
      StringCalculator.add("1\n2\n3") should equal(6)
    }

    it("allows a mixture of comma and newline separators") {
      StringCalculator.add("1\n2,3") should equal(6)
    }

    it("allows the delimiter to be specified") {
      StringCalculator.add("//;\n1;2") should equal(3)
    }
  }
}

