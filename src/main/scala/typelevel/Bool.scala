package typelevel

sealed trait BoolVal {
  def not: BoolVal
  def or(that: BoolVal): BoolVal
}

case object TrueVal extends BoolVal {
  override val not = FalseVal
  override def or(that: BoolVal) = TrueVal
}

case object FalseVal extends BoolVal {
  override val not = TrueVal
  override def or(that: BoolVal) = that
}

sealed trait BoolType {
  type Not <: BoolType
  type Or[That <: BoolType] <: BoolType
}

trait TrueType extends BoolType {
  override type Not = FalseType
  override type Or[That <: BoolType] = TrueType
}

trait FalseType extends BoolType {
  override type Not = TrueType
  override type Or[That <: BoolType] = That
}
