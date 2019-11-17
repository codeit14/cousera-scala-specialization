package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c > r) throw new IllegalArgumentException("Column cannot be larger than row")
    if (c == 0 || c == r) return 1
    pascal(c - 1, r - 1) + pascal(c, r - 1);
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceUsingParenthesesCount(chars: List[Char], count: Int): Boolean = {
      if (chars.isEmpty) return count == 0
      if (count < 0) return false
      if (chars.head == '(') return balanceUsingParenthesesCount(chars.tail, count + 1)
      if (chars.head == ')') return balanceUsingParenthesesCount(chars.tail, count - 1)
      balanceUsingParenthesesCount(chars.tail, count)
    }

    balanceUsingParenthesesCount(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) return 1
    if (coins.isEmpty || money < 0) return 0
    countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
