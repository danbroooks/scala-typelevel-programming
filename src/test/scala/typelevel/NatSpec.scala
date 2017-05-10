package typelevel

import NatType._
import org.scalatest._

class NatSpec extends FreeSpec with Matchers {
  "NatVal" - {
    val zero = NatVal0
    val one = NatValN(zero)
    val two = NatValN(one)
    val three = NatValN(two)

    "+ should implement addition" in {
      zero + zero should be(zero)
      zero + one should be(one)
      one + one should be(two)
      two + one should be(three)
    }
  }

  "NatType" - {
    type Zero = NatType0
    type One = NatTypeN[Zero]
    type Two = NatTypeN[One]
    type Three = NatTypeN[Two]

    "+ should implement addition" in {
      implicitly[(Zero + Zero) =:= Zero]
      implicitly[(Zero + One) =:= One]
      implicitly[(One + One) =:= Two]
      implicitly[(Two + One) =:= Three]
    }
  }
}
