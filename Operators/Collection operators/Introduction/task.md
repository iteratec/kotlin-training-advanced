## Collection operators
| Operator      | Translation    | Description          |
|---------------|----------------|----------------------|
| `a[i]`        | a.get(i)       | Get i-th element     |
| `a[i] = b`    | a.set(i, b)    | Set i-th element     |
| `a[i, j]`     | a.get(i, j)    | Get i,j-th element   |
| `a[i, j] = b` | a.set(i, j, b) | Set i,j-th element   |
| `a in b`      | b.contains(a)  | Is a member of b     |
| `a !in b`     | !b.contains(a) | Is a not member of b |

For collection-like classes Kotlin provides operators that allow you to easily
get or set elements with the index notation: `a[i] = value`. Additionally, you
can use `in` and `!in` operators which test for presence of the given element in the
collection. All these operators are available by default in Kotlin's standard collections.