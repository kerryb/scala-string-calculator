import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class NegativeInputExceptionSpec extends Spec with ShouldMatchers {
  describe ("NegativeInputException") {
    it ("formats the message correctly with one number") {
      new NegativeInputException(Array(-1)).getMessage should equal ("negatives not allowed: -1")
    }

    it ("formats the message correctly with several numbers") {
      new NegativeInputException(Array(-1, -2, -3)).getMessage should equal ("negatives not allowed: -1, -2, -3")
    }
  }
}
