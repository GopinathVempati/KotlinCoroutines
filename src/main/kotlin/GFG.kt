fun main() {
    val a = arrayOf(intArrayOf(1,2,3,4), intArrayOf(5,6,7,8), intArrayOf(9,10,11,12), intArrayOf(13,14,15,16))
    val R = a.size
    val C = a.first().size
    println(spiralPrint(R, C, a))
}

private fun spiralPrint(m: Int, n: Int, a: Array<IntArray>) {
    var m = m
    var n = n
    var i: Int
    var k = 0
    var l = 0

    /* k - starting row index
    m - ending row index
    l - starting column index
    n - ending column index
    i - iterator
    */while (k < m && l < n) {
        // Print the first row from the remaining rows
        i = l
        while (i < n) {
            print(a[k][i].toString() + " ")
            ++i
        }
        k++

        // Print the last column from the remaining
        // columns
        i = k
        while (i < m) {
            print(a[i][n - 1].toString() + " ")
            ++i
        }
        n--

        // Print the last row from the remaining rows */
        if (k < m) {
            i = n - 1
            while (i >= l) {
                print(a[m - 1][i].toString() + " ")
                --i
            }
            m--
        }

        // Print the first column from the remaining
        // columns */
        if (l < n) {
            i = m - 1
            while (i >= k) {
                print(a[i][l].toString() + " ")
                --i
            }
            l++
        }
    }
}
