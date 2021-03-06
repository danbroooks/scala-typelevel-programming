package typelevel

import org.scalatest._

class VectorSpec extends FreeSpec with Matchers {
  "Vector" - {
    "can be combined" in {
      val sum = (1 :: 2 :: VNil) + (3 :: 4 :: VNil)
      sum shouldEqual 4 :: 6 :: VNil
    }
  }
}
