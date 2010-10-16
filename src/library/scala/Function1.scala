/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2002-2010, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

// generated by genprod on Sat Oct 16 11:19:09 PDT 2010 (with fancy comment) (with extra methods)

package scala




/** Function with 1 parameter.
 *
 * In the following example the definition of
 *    succ is a shorthand for the anonymous class
 *    definition anonfun1:
 *
 *  {{{
 *  object Main extends Application {
 *    val succ = (x: Int) => x + 1
 *
 *    val anonfun1 = new Function1[Int, Int] {
 *      def apply(x: Int): Int = x + 1
 *    }
 *
 *    println(succ(0))
 *    println(anonfun1(0))
 *  }
 *  }}}
 */
trait Function1[@specialized(scala.Int, scala.Long, scala.Float, scala.Double) -T1, @specialized(scala.Unit, scala.Boolean, scala.Int, scala.Float, scala.Long, scala.Double) +R] extends AnyRef { self =>
  def apply(v1:T1): R
  override def toString() = "<function1>"

  /** (f compose g)(x) ==  f(g(x))
   */
  def compose[A](g: A => T1): A => R = { x => apply(g(x)) }

  /** (f andThen g)(x) ==  g(f(x))
   */
  def andThen[A](g: R => A): T1 => A = { x => g(apply(x)) }

  /** Turns a function A => Option[B] into a PartialFunction[A, B].  Important note:
   *  this transformation implies the original function will be called 2 or more
   *  times on each logical invocation, because the only way to supply an implementation
   *  of isDefinedAt is to call the function and examine the return value.
   *
   *  @see     PartialFunction#lift
   *  @return  a partial function which is defined for those inputs
   *           where this function returns Some(_) and undefined where
   *           this function returns None.
   */
  def unlift[R1](implicit ev: R <:< Option[R1]): PartialFunction[T1, R1] = new PartialFunction[T1, R1] {
    def apply(x: T1): R1 = ev(Function1.this.apply(x)).get
    def isDefinedAt(x: T1): Boolean = Function1.this.apply(x).isDefined
    override def lift = Function1.this.asInstanceOf[T1 => Option[R1]]
  }

}
