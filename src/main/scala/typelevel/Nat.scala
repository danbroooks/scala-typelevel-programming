package typelevel

sealed trait NatVal {
  def +(that: NatVal): NatVal
}

case object NatVal0 extends NatVal {
  override def +(that: NatVal) = that
}

case class NatValN(prev: NatVal) extends NatVal {
  override def +(that: NatVal) = NatValN(prev + that)
}

sealed trait NatType {
  type plus[That <: NatType] <: NatType
}

sealed trait NatType0 extends NatType {
  type plus[That <: NatType] = That
}

sealed trait NatTypeN[Prev <: NatType] extends NatType {
  type plus[That <: NatType] = NatTypeN[Prev#plus[That]]
}

object NatType {
  type +[A <: NatType, B <: NatType] = A#plus[B]
}
