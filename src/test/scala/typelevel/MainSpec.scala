package typelevel

import org.scalatest._

class MainSpec extends FreeSpec with Matchers {
  "nothing" - {
    "to see" in {
      false should be(false)
    }
  }
}
