package typelevel

import org.scalatest._

class BoolSpec extends FreeSpec with Matchers {
  "BoolVal" - {
    "TrueVal" - {
      TrueVal should equal(TrueVal)
      TrueVal should not equal(FalseVal)

      ".not inverts the condition" in {
        TrueVal.not should equal(FalseVal)
      }

      ".or should always return true" in {
        TrueVal.or(TrueVal) should equal(TrueVal)
        TrueVal.or(FalseVal) should equal(TrueVal)
      }
    }

    "FalseVal" - {
      FalseVal should equal(FalseVal)
      FalseVal should not equal(TrueVal)

      ".not inverts the condition" in {
        FalseVal.not should equal(TrueVal)
      }

      ".or should return the right hand side value" in {
        FalseVal.or(TrueVal) should equal(TrueVal)
        FalseVal.or(FalseVal) should equal(FalseVal)
      }
    }
  }

  "BoolType" - {
    "TrueType" - {
      implicitly[TrueType =:= TrueType]
      "implicitly[TrueType =:= FalseType]" shouldNot compile

      "#not inverts the condition" in {
        implicitly[TrueType#Not =:= FalseType]
      }

      ".or should always return true" in {
        implicitly[TrueType#Or[TrueType] =:= TrueType]
        implicitly[TrueType#Or[FalseType] =:= TrueType]
      }
    }

    "FalseType" - {
      implicitly[FalseType =:= FalseType]
      "implicitly[FalseType =:= TrueType]" shouldNot compile

      "#not inverts the condition" in {
        implicitly[FalseType#Not =:= TrueType]
      }

      ".or should return the right hand side value" in {
        implicitly[FalseType#Or[TrueType] =:= TrueType]
        implicitly[FalseType#Or[FalseType] =:= FalseType]
      }
    }
  }
}
