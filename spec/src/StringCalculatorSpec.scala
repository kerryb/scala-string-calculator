import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class StringCalculatorSpec extends Spec with ShouldMatchers {
  describe("StringCalculator") {
    it("calculates the sum of an empty string as 0") {
      StringCalculator.add("") should equal(0)
    }
  }
}

